package com.capgemini.coedevon.teammanager.absence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.absence.model.AbsenceDto;
import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;

/**
 * @author pajimene
 *
 */
@RequestMapping(value = "/absence")
@RestController
public class AbsenceController {

  @Autowired
  AbsenceService absenceService;

  @Autowired
  private BeanMapper beanMapper;

  /**
   * Recupera la ausencias de una persona para un año
   * @param year
   * @param username
   * @return
   */
  @RequestMapping(path = "/{year}/username/{username}", method = RequestMethod.GET)
  public List<AbsenceDto> findAbsenceByUsername(@PathVariable("year") Integer year,
      @PathVariable("username") String username) {

    return this.beanMapper.mapList(this.absenceService.findAbsenceByUsername(year, username), AbsenceDto.class);

  }

  /**
   * Recupera las ausencias de un grupo de personas para un año
   * @param year
   * @param groupId
   * @return
   */
  @RequestMapping(path = "/{year}/group/{groupId}", method = RequestMethod.GET)
  public List<AbsenceDto> findAbsenceByGroup(@PathVariable("year") Integer year,
      @PathVariable("groupId") Long groupId) {

    return this.beanMapper.mapList(this.absenceService.findAbsenceByGroup(year, groupId), AbsenceDto.class);

  }

}
