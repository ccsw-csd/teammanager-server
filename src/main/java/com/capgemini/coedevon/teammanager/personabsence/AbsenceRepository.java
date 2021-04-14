package com.capgemini.coedevon.teammanager.personabsence;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.personabsence.model.AbsenceEntity;

/**
 * @author aolmosca
 *
 */
public interface AbsenceRepository extends CrudRepository<AbsenceEntity, Integer> {

  AbsenceEntity findByDateAndSaga(Date date, String saga);

}
