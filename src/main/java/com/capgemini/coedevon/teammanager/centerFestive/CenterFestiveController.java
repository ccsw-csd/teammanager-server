
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
   * @param dtoEdit
   * @return
   */
  @RequestMapping(path = "/editFestives/", method = RequestMethod.POST)
  public List<CenterFestiveDto> editFestives(@RequestBody CenterFestiveSearchDto dtoEdit) {

    return this.beanMapper.mapList(
        this.centerFestiveService.findFestiveAndCenter(dtoEdit.getCenterid(), dtoEdit.getYear()),
        CenterFestiveDto.class);
  }

  /**
   * @param dtoSave
   */
  @RequestMapping(path = "/save/", method = RequestMethod.POST)
  public void saveFestives(@RequestBody CenterFestiveSaveDto dtoSave) {

    this.centerFestiveService.crearFestivos(dtoSave.getYear(), dtoSave.getCenterid(), dtoSave.getDates());

  }
}
