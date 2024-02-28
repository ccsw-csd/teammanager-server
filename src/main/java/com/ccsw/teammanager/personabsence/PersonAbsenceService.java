package com.ccsw.teammanager.personabsence;

import java.util.Date;
import java.util.List;

import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

public interface PersonAbsenceService {

    List<PersonAbsenceEntity> findAllByPersonIdInAndDateBetween(List<Long> membersId, Date startDate, Date endDate);

    List<PersonAbsenceEntity> findAllByPersonIdAndYear(Long personId, int year);

    List<PersonAbsenceEntity> save(List<PersonAbsenceDto> data);

    void delete(String id) throws Exception;
}
