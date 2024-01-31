package com.ccsw.teammanager.personabsence;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.teammanager.person.model.PersonEntity;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

/**
 *
 */
public interface PersonAbsenceRepository extends CrudRepository<PersonAbsenceEntity, String> {

    List<PersonAbsenceEntity> findByPersonAndDateBetween(PersonEntity person, Date startDate, Date endDate);

    List<PersonAbsenceEntity> findByPersonIdAndYearAndMonth(Long person_id, Integer year, Integer month);
}
