package com.capgemini.coedevon.teammanager.personabsence;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.capgemini.coedevon.teammanager.personabsence.model.PersonAbsenceDto;

/**
 * @author aolmosca
 *
 */
public interface PersonAbsenceService {

  Map<Integer, List<PersonAbsenceDto>> findYearAndUsername(String username, Integer year);

  void save(Integer year, List<PersonAbsenceDto> dtos, List<Date> dates, String username);

}
