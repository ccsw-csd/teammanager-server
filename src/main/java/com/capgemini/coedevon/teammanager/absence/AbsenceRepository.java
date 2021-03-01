package com.capgemini.coedevon.teammanager.absence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.absence.model.AbsenceEntity;

/**
 * @author pajimene
 *
 */
public interface AbsenceRepository extends CrudRepository<AbsenceEntity, String>, AbsenceRepositoryCustom {

  /**
   * Recupera la ausencias de un año para un usuario
   * @param year
   * @param username
   * @return
   */
  List<AbsenceEntity> findAbsenceByYearAndUsername(Integer year, String username);

}
