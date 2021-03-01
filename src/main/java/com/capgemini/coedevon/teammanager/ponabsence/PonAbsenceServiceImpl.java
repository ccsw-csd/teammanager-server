package com.capgemini.coedevon.teammanager.ponabsence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.ponabsence.model.PonAbsenceDto;

/**
 * @author pajimene
 *
 */
@Service
@Transactional(readOnly = true)
public class PonAbsenceServiceImpl implements PonAbsenceService {

  private static final Logger LOG = LoggerFactory.getLogger(PonAbsenceServiceImpl.class);

  @Autowired
  PonAbsenceRepository ponAbsenceRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = false)
  public void importDataFromPON() {

    List<PonAbsenceDto> ponAbsenceList;
    try {
      ponAbsenceList = this.ponAbsenceRepository.findAllAbsencesFromPon();
    } catch (Exception e) {
      LOG.error("Error en PON", e);
      return;
    }

    this.ponAbsenceRepository.deleteAllTemporary();
    this.ponAbsenceRepository.persistAllTemporary(ponAbsenceList);
    this.ponAbsenceRepository.moveTemporaryToRealAbsence();
  }

}
