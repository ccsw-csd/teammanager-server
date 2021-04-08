package com.capgemini.coedevon.teammanager.forecast;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.config.security.UserUtils;
import com.capgemini.coedevon.teammanager.forecast.absence.PersonGroupAbsenceService;
import com.capgemini.coedevon.teammanager.forecast.absence.model.PersonGroupAbsenceDto;
import com.capgemini.coedevon.teammanager.forecast.absence.model.PersonGroupAbsenceSearchDto;

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
  private PersonGroupAbsenceService vAbsenceService;

  /**
   * Recupera la ausencias de una persona para un año
   *
   * @param year
   * @param username
   * @return
   */
  @RequestMapping(path = "/", method = RequestMethod.POST)
  public Map<String, List<PersonGroupAbsenceDto>> getGroupAbsenceByDate(@RequestBody PersonGroupAbsenceSearchDto dto) {

    return this.vAbsenceService.getGroupAbsenceByDate(dto.getGroupId(), dto.getInit(), dto.getEnd());
  }

  @RequestMapping(path = "/{year}/fromUser/", method = RequestMethod.GET)
  public Map<Integer, List<PersonGroupAbsenceDto>> getYearAndUsername(@PathVariable("year") Integer year) {

    String username = UserUtils.getUserDetails().getUsername();

    return this.vAbsenceService.findYearAndUsername(username, year);

  }
}
