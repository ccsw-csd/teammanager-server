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

  void save(List<Date> dates, List<PersonAbsenceDto> absence, String username);

}
