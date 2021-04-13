package com.capgemini.coedevon.teammanager.forecast.absence;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.capgemini.coedevon.teammanager.forecast.absence.model.PersonGroupAbsenceDto;

/**
 * @author aolmosca
 *
 */
public interface PersonGroupAbsenceService {

  Map<String, List<PersonGroupAbsenceDto>> getGroupAbsenceByDate(Long groupId, Date init, Date end);
}
