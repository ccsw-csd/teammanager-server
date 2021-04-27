package com.capgemini.coedevon.teammanager.centerFestive;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface CenterFestiveRepository extends CrudRepository<CenterFestiveEntity, Long> {

  /**
   * @param year
   * @param centerID
   * @return
   */
  List<CenterFestiveEntity> findAllByCenteridAndYear(long centerid, int year);

  /**
   * @param Centerid
   */
  @Transactional
  void deleteAllByCenterid(long Centerid);

}
