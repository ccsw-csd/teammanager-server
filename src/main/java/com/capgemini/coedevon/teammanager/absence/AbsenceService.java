package com.capgemini.coedevon.teammanager.absence;

import java.util.List;

import com.capgemini.coedevon.teammanager.absence.model.AbsenceEntity;

/**
 * @author pajimene
 *
 */
public interface AbsenceService {

  /**
   * Regenera la tabla de Ausencia
   * Si se le pasa un username solo regenera los datos de ese username
   * @param username
   * @param year
   * @return
   */
  void regenerateTable(Integer year, String username);

  /**
   * Recupera la ausencias de un año para un usuario
   * @param year
   * @param username
   * @return
   */
  List<AbsenceEntity> findAbsenceByUsername(Integer year, String username);

  /**
   * Recupera las ausencias de un año para un grupo de usuarios
   * @param year
   * @param groupId
   * @return
   */
  List<AbsenceEntity> findAbsenceByGroup(Integer year, Long groupId);

}
