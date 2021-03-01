package com.capgemini.coedevon.teammanager.ponabsence;

/**
 * @author pajimene
 *
 */
public interface PonAbsenceService {

  /**
   * Realiza una carga del PON a la tabla temporal
   * @return
   */
  void importDataFromPON();
}
