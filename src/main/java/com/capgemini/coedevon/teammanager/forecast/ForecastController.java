package com.capgemini.coedevon.teammanager.forecast;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.forecast.model.ForecastDto;
import com.capgemini.coedevon.teammanager.forecast.model.ForecastSearchDto;

/**
 * @author aolmosca
 *
 */
@RequestMapping(value = "/forecast")
@RestController
public class ForecastController {

  @Autowired
  private BeanMapper beanMapper;

  @Autowired
  private ForecastService vAbsenceService;

  /**
   * Recupera la ausencias de una persona para un año
   *
   * @param year
   * @param username
   * @return
   */
  @RequestMapping(path = "/", method = RequestMethod.POST)
  public Map<String, List<ForecastDto>> getGroupAbsenceByDate(@RequestBody ForecastSearchDto dto) {

    return this.vAbsenceService.getGroupAbsenceByDate(dto.getGroupId(), dto.getInit(), dto.getEnd());
  }

}
