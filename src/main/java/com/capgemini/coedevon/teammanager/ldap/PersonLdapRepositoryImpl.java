package com.capgemini.coedevon.teammanager.ldap;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.coedevon.teammanager.ldap.model.PersonRawDto;

/**
 * @author pajimene
 *
 */
@Repository
public class PersonLdapRepositoryImpl implements PersonLdapRepository {

  private static final Logger LOG = LoggerFactory.getLogger(PersonLdapRepositoryImpl.class);

  private static final String LDAP_QUERY = "OU=ES,OU=Employees,DC=CORP,DC=CAPGEMINI,DC=COM";

  private static final String[] ATTRIBUTES = new String[] { "cn", "userPrincipalName", "employeeNumber", "givenName",
  "sn", "st", "capgemini-Grade", "capgemini-opBusinessCode", "Capgemini-puCode", "capgemini-StartDate",
  "capgemini-JobRole" };

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Value("${ldap.username}")
  private String ldapUsername;

  @Value("${ldap.password}")
  private String ldapPassword;

  @Value("${ldap.url}")
  private String ldapUrl;

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteAllTemporary() {

    this.jdbcTemplate.update("delete from t_person");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moveTemporaryToRealPerson() {

    this.jdbcTemplate
        .update("INSERT INTO person (saga, username, email, name, lastname, center_id, businesscode, active) " + //
            "select p.saga, p.username, p.email, p.name, p.lastname, ct.center_id, p.businesscode, 1 " + //
            "from " + //
            "    t_person p left join center_transcode ct on p.center = ct.name " + //
            "where " + //
            "    p.saga != '' and p.saga not in (select saga from person)");
    this.jdbcTemplate.update("update person set active = 0");
    this.jdbcTemplate.update("update person set active = 1 where saga in (select saga from t_person)");

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void persistAllTemporary(List<PersonRawDto> list) {

    final int batchSize = 500;

    for (int j = 0; j < list.size(); j += batchSize) {

      final List<PersonRawDto> batchList = list.subList(j, j + batchSize > list.size() ? list.size() : j + batchSize);

      this.jdbcTemplate.batchUpdate(
          "INSERT INTO t_person (saga, username, email, name, lastname, center, grade, businesscode, pucode, startdate, jobrole) VALUES(?,?,?,?,?,?,?,?,?,?,?)",
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {

              PersonRawDto entity = batchList.get(i);

              ps.setString(1, entity.getSaga());
              ps.setString(2, entity.getUsername());
              ps.setString(3, entity.getEmail());
              ps.setString(4, entity.getName());
              ps.setString(5, entity.getLastname());
              ps.setString(6, entity.getCenter());
              ps.setString(7, entity.getGrade());
              ps.setString(8, entity.getBusinesscode());
              ps.setString(9, entity.getPucode());
              ps.setString(10, entity.getStartdate());
              ps.setString(11, entity.getJobRole());

            }

            @Override
            public int getBatchSize() {

              return batchList.size();
            }
          });

    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<PersonRawDto> findAllPersonFromLDAP() {

    Hashtable<String, String> env = new Hashtable<>();
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, this.ldapUrl.concat(LDAP_QUERY));
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, this.ldapUsername);
    env.put(Context.SECURITY_CREDENTIALS, this.ldapPassword);

    DirContext ctx;
    try {
      ctx = new InitialDirContext(env);
    } catch (NamingException e) {
      throw new RuntimeException(e);
    }

    List<PersonRawDto> list = new LinkedList<>();
    NamingEnumeration<?> results = null;
    try {
      SearchControls controls = new SearchControls();
      controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
      controls.setReturningAttributes(ATTRIBUTES);

      results = ctx.search("", "(objectclass=user)", controls);

      while (results.hasMoreElements()) {
        SearchResult searchResult = (SearchResult) results.next();
        Attributes attributes = searchResult.getAttributes();

        list.add(getPersonEtoFromAttributes(attributes));
      }
    } catch (NameNotFoundException e) {
      LOG.error("The base context was not found.", e);
    } catch (NamingException e) {
      throw new RuntimeException(e);
    } finally {
      if (results != null) {
        try {
          results.close();
        } catch (Exception e) {
          LOG.error("Error trying to close the NamingEnumeration", e);
        }
      }
      if (ctx != null) {
        try {
          ctx.close();
        } catch (Exception e) {
          LOG.error("Error trying to close the DirContext", e);
        }
      }
    }
    return list;
  }

  private PersonRawDto getPersonEtoFromAttributes(Attributes attributes) {

    PersonRawDto person = new PersonRawDto();
    try {
      person.setUsername(get(attributes, "cn"));
      person.setEmail(get(attributes, "userPrincipalName"));
      person.setSaga(get(attributes, "employeeNumber"));
      person.setName(get(attributes, "givenName"));
      person.setLastname(get(attributes, "sn"));
      person.setCenter(get(attributes, "st"));
      person.setGrade(get(attributes, "capgemini-Grade"));
      person.setBusinesscode(get(attributes, "capgemini-opBusinessCode"));
      person.setPucode(get(attributes, "Capgemini-puCode"));
      person.setStartdate(get(attributes, "capgemini-StartDate"));
      person.setJobRole(get(attributes, "capgemini-JobRole"));
    } catch (NamingException e) {
      LOG.error("Error trying to get an attribute.", e);
    }

    return person;
  }

  private String get(Attributes attributes, String key) throws NamingException {

    if (attributes == null)
      return "";
    if (attributes.get(key) == null)
      return "";
    if (attributes.get(key).get() == null)
      return "";

    return attributes.get(key).get().toString();

  }

}
