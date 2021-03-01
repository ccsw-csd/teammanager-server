package com.capgemini.coedevon.teammanager.absence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @author pajimene
 *
 */
@Repository
public class AbsenceRepositoryCustomImpl implements AbsenceRepositoryCustom {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * {@inheritDoc}
   */
  @Override
  public void regenerateTable(Integer year, String username) {

    String deleteQuery = "delete from absence";
    String insertQuery = "insert into absence(id, saga, username, name, lastname, center_id, active, year, month, date, type) "
        + "select concat(saga, '-', username, '-', date, '-', type) as id, saga, username, name, lastname, center_id, active, year, month, DATE_ADD(date, INTERVAL 12 HOUR), type "
        + "from v_person_absence";

    String whereQuery = "";
    if (year != null) {
      whereQuery += " where year = " + year;

      if (StringUtils.hasText(username)) {
        whereQuery += " and username = '" + username + "'";
      }
    }

    this.jdbcTemplate.update(deleteQuery + whereQuery);
    this.jdbcTemplate.update(insertQuery + whereQuery);
  }

}
