package com.ccsw.teammanager.personabsence;

import java.util.Date;
import java.util.List;

import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

public interface PersonAbsenceService {

    List<PersonAbsenceEntity> findAllByPersonIdInAndDateBetween(List<Long> membersId, Date startDate, Date endDate);
}
