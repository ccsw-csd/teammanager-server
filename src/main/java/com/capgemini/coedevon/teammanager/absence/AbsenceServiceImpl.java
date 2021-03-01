package com.capgemini.coedevon.teammanager.absence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.absence.model.AbsenceEntity;

/**
 * @author pajimene
 *
 */
@Service
@Transactional(readOnly = true)
public class AbsenceServiceImpl implements AbsenceService {

  @Autowired
  AbsenceRepository absenceRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = false)
  public void regenerateTable(Integer year, String username) {

    this.absenceRepository.regenerateTable(year, username);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<AbsenceEntity> findAbsenceByUsername(Integer year, String username) {

    return this.absenceRepository.findAbsenceByYearAndUsername(year, username);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<AbsenceEntity> findAbsenceByGroup(Integer year, Long groupId) {

    //TODO Falta por hacer
    //return this.absenceRepository.findAbsenceByGroup(year, groupId);
    return null;
  }

}
