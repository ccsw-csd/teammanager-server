package com.capgemini.coedevon.teammanager.ldap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Value("${files.path}")
  private String filesPath;

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

    try {
      String fileName = this.filesPath + "/ldapPerson.csv";
      List<String> contentFile = readFromFile(fileName);

      List<PersonRawDto> persons = new ArrayList<>(contentFile.size());

      for (String line : contentFile) {
        persons.add(getPersonDtoFromLine(line));
      }
      return persons;

    } catch (Exception e) {
      LOG.error("Error read csv.", e);
      return new ArrayList<>();
    }

  }

  private PersonRawDto getPersonDtoFromLine(String line) {

    PersonRawDto person = new PersonRawDto();
    try {

      line += " "; //Añadimos un espacio en blanco para que haga el split correctamente aunque acabe en ;
      String dataRaw[] = line.split(";");

      person.setUsername(dataRaw[0]);
      person.setEmail(dataRaw[1]);
      person.setSaga(dataRaw[2]);
      person.setName(dataRaw[3]);
      person.setLastname(dataRaw[4]);
      person.setCenter(dataRaw[5]);
      person.setGrade(dataRaw[6]);
      person.setBusinesscode(dataRaw[7]);
      person.setPucode(dataRaw[8]);
      person.setStartdate(dataRaw[9]);
      person.setJobRole(dataRaw[10].trim());

    } catch (Exception e) {
      LOG.error("Error read csv line: [" + line + "]", e);
    }

    return person;
  }

  private List<String> readFromFile(String fileName) throws IOException {

    InputStream inputStream = new FileInputStream(fileName);
    List<String> result = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        result.add(line);
      }
    }
    return result;
  }
}
