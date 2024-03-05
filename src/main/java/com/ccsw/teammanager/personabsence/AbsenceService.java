package com.ccsw.teammanager.personabsence;

import java.util.List;

import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;

public interface AbsenceService {

    void save(List<PersonAbsenceDto> data);

    void delete(List<PersonAbsenceDto> data);

}
