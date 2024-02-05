package com.ccsw.teammanager.personabsence;

import java.util.Date;
import java.util.List;

import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

public interface PersonAbsenceService {

    List<PersonAbsenceEntity> findAbsences(Long person_id, Date startDate, Date endDate);

    List<PersonAbsenceEntity> findAbsencesByIdAndDate(Long person_id, Integer year, Integer month);

    List<PersonAbsenceEntity> findAllByPersonIdInAndYearAndMonth(List<Long> membersId, Integer year, Integer month);

    List<PersonAbsenceEntity> findAllByPersonIdInAndDateBetween(List<Long> membersId, Date startDate, Date endDate);
}
