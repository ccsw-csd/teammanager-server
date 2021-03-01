package com.capgemini.coedevon.teammanager.ponabsence;

import java.util.List;

import com.capgemini.coedevon.teammanager.ponabsence.model.PonAbsenceDto;

/**
 * @author pajimene
 *
 */
public interface PonAbsenceRepository {

  /**
   * Recupera las ausencias de PON
   * @return
   * @throws Exception
   */
  List<PonAbsenceDto> findAllAbsencesFromPon() throws Exception;

  /**
   * Borra los registros de la tabla temporal
   */
  void deleteAllTemporary();

  /**
   * Persiste las ausencias en la tabla temporal
   * @param list
   */
  void persistAllTemporary(List<PonAbsenceDto> list);

  /**
   * Mueve las ausencias de la tabla temporal a la tabla real
   */
  void moveTemporaryToRealAbsence();

}
