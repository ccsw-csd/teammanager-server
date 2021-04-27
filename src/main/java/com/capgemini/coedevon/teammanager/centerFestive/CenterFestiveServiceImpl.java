package com.capgemini.coedevon.teammanager.centerFestive;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveEntity;

/**
 * TODO apastorm This type ...
 *
 */
@Service
public class CenterFestiveServiceImpl implements CenterFestiveService {

  @Autowired
  CenterFestiveRepository centerFestiveRepository;

  /**
   * @param centerID
   * @param year
   * @return
   */
  @Override
  public List<CenterFestiveEntity> findFestiveAndCenter(long centerid, int year) {

    List<CenterFestiveEntity> centerFestiveEntity = new ArrayList<CenterFestiveEntity>();

    centerFestiveEntity = this.centerFestiveRepository.findAllByCenteridAndYear(centerid, year);

    return centerFestiveEntity;
  }

  @Override
  public void crearFestivos(int centerid, int year, List<Date> dates) {

    this.centerFestiveRepository.deleteAllByCenterid(centerid);

    for (int i = 0; i < dates.size(); i++) {
      CenterFestiveEntity festivo = new CenterFestiveEntity();
      festivo.setCenterid(centerid);
      festivo.setDate(dates.get(i));
      festivo.setYear(year);
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(dates.get(i));
      festivo.setMonth(calendar.get(Calendar.MONTH) + 1);
      this.centerFestiveRepository.save(festivo);
    }

  }
}
