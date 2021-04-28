package com.capgemini.coedevon.teammanager.centerFestive;

import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface FestiveRepository {

  @SuppressWarnings("javadoc")
  CenterFestiveEntity findAllByCenteridAndYear(long centerid, int year);
}
