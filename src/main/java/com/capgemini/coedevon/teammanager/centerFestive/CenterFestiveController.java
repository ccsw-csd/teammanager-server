
package com.capgemini.coedevon.teammanager.centerFestive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveDto;
import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveSaveDto;
import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveSearchDto;
import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;

@RequestMapping(value = "/festives")
@RestController
public class CenterFestiveController {

  @Autowired
  private BeanMapper beanMapper;

  @Autowired
  CenterFestiveService centerFestiveService;

  /**
   * @param centerID
   * @param year
   * @return
   */
  @RequestMapping(path = "/editFestives/", method = RequestMethod.POST)
  public List<CenterFestiveDto> editFestives(@RequestBody CenterFestiveSearchDto dto) {

    return this.beanMapper.mapList(this.centerFestiveService.findFestiveAndCenter(dto.getCenterID(), dto.getYear()),
        CenterFestiveDto.class);

  }

  /**
   * @param year
   * @param fechas
   * @param dto
   */
  @RequestMapping(path = "/save/", method = RequestMethod.POST)
  public void saveFestives(@RequestBody CenterFestiveSaveDto dto) {

    this.centerFestiveService.crearFestivos(dto.getCenterid(), dto.getYear(), dto.getDates());

  }
}
