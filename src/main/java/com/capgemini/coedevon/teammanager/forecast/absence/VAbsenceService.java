package com.capgemini.coedevon.teammanager.forecast.absence;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.capgemini.coedevon.teammanager.forecast.absence.model.VAbsenceDto;

/**
 * @author aolmosca
 *
 */
public interface VAbsenceService {

  Map<String, List<VAbsenceDto>> getGroupAbsenceByDate(Long groupId, Date init, Date end);

}
