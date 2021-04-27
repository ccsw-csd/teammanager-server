package com.capgemini.coedevon.teammanager.centerFestive;

import java.sql.Date;
import java.util.List;

import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface CenterFestiveService {

  /**
   * @param centerID
   * @param year
   * @return
   */
  List<CenterFestiveEntity> findFestiveAndCenter(long centerid, int year);

  /**
   * @param centerid
   * @param year
   * @param dates
   */
  void crearFestivos(int centerid, int year, List<Date> dates);
}
