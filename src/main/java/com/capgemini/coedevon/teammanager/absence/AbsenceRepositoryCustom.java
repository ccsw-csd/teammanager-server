package com.capgemini.coedevon.teammanager.absence;

/**
 * @author pajimene
 *
 */
public interface AbsenceRepositoryCustom {

  /**
   * Regenera la tabla de Ausencia
   * Si se le pasa un username solo regenera los datos de ese username
   * @param year
   * @param username
   */
  void regenerateTable(Integer year, String username);

}
