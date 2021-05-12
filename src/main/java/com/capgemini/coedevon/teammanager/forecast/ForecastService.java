package com.capgemini.coedevon.teammanager.forecast;

import java.io.File;
import java.util.Date;
import java.util.Map;

import com.capgemini.coedevon.teammanager.forecast.model.ForecastDetailDto;

/**
 * @author aolmosca
 *
 */
public interface ForecastService {

  Map<String, ForecastDetailDto> getGroupAbsenceByDate(Long groupId, Date init, Date end);

  File exportForecast(Long groupId, Date init, Date end, int type);
}
