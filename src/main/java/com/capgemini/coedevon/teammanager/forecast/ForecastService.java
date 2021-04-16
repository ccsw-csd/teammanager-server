package com.capgemini.coedevon.teammanager.forecast;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.capgemini.coedevon.teammanager.forecast.model.ForecastDto;

/**
 * @author aolmosca
 *
 */
public interface ForecastService {

  Map<String, List<ForecastDto>> getGroupAbsenceByDate(Long groupId, Date init, Date end);
}
