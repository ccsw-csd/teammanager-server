package com.ccsw.teammanager.personabsence;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

/**
 *
 */
public interface PersonAbsenceRepository extends CrudRepository<PersonAbsenceEntity, String> {

    List<PersonAbsenceEntity> findAllByPersonIdInAndDateBetween(List<Long> membersId, Date startDate, Date endDate);

    List<PersonAbsenceEntity> findAllByPersonIdAndYear(Long personId, int year);
}
