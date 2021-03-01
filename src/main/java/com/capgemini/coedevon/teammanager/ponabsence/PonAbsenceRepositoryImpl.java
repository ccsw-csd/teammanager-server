package com.capgemini.coedevon.teammanager.ponabsence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.capgemini.coedevon.teammanager.config.SSLUtil;
import com.capgemini.coedevon.teammanager.ponabsence.model.PonAbsenceDto;

/**
 * @author pajimene
 *
 */
@Repository
public class PonAbsenceRepositoryImpl implements PonAbsenceRepository {

  private static final Logger LOG = LoggerFactory.getLogger(PonAbsenceRepositoryImpl.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * {@inheritDoc}
   */
  @Override
  public void deleteAllTemporary() {

    this.jdbcTemplate.update("delete from t_absence");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moveTemporaryToRealAbsence() {

    this.jdbcTemplate.update("delete from absence_pon where year in (select distinct year from t_absence)");
    this.jdbcTemplate.update("delete from t_absence where status = 'R'");
    this.jdbcTemplate.update("insert into absence_pon(id, saga, year, month, date, status) " + //
        "select @i:=@i+1, t.* " + //
        "from ( " + //
        "    select distinct saga, year, month(d.date) as month, d.date, status " + //
        "    from t_absence a join dates d on d.date between a.from_date and a.to_date " + //
        ") t, (SELECT @i:=0) AS foo");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void persistAllTemporary(List<PonAbsenceDto> list) {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    final int batchSize = 500;

    for (int j = 0; j < list.size(); j += batchSize) {

      final List<PonAbsenceDto> batchList = list.subList(j, j + batchSize > list.size() ? list.size() : j + batchSize);

      this.jdbcTemplate.batchUpdate(
          "INSERT INTO t_absence (year, saga, from_date, to_date, days, status) VALUES(?,?,?,?,?,?)",
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {

              PonAbsenceDto entity = batchList.get(i);

              ps.setInt(1, entity.getAnio());
              ps.setString(2, entity.getCodSaga());
              try {
                ps.setDate(3, new java.sql.Date(dateFormat.parse(entity.getDesde()).getTime()));
                ps.setDate(4, new java.sql.Date(dateFormat.parse(entity.getHasta()).getTime()));
              } catch (ParseException e) {
              }
              ps.setInt(5, entity.getDias());
              ps.setString(6, entity.getEstado());

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
  public List<PonAbsenceDto> findAllAbsencesFromPon() throws Exception {

    RestTemplate restTemplate = new RestTemplate();

    SSLUtil.turnOffSslChecking();

    String url = "https://alexandra.es.capgemini.com/public/absences/get/?user=teamManager&password=teamManager.2021";
    ResponseEntity<PonAbsenceDto[]> responseEntity = restTemplate.getForEntity(url, PonAbsenceDto[].class);

    SSLUtil.turnOnSslChecking();

    return Arrays.asList(responseEntity.getBody());
  }

}
