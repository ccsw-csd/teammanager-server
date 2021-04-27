package com.capgemini.coedevon.teammanager.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.center.model.CenterDto;
import com.capgemini.coedevon.teammanager.center.model.ListadoCentrosFestivosDto;
import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;

/**
 * @author aolmosca
 *
 */
@RequestMapping(value = "/center")
@RestController
public class CenterController {

  @Autowired
  CenterService centerService;

  @Autowired
  private BeanMapper beanMapper;

  @RequestMapping(path = "/", method = RequestMethod.POST)
  public List<CenterDto> get() {

    return this.beanMapper.mapList(this.centerService.getAllCenters(), CenterDto.class);

  }

  /**
   * @return
   */
  @RequestMapping(path = "/festiveCenter/", method = RequestMethod.GET)
  public List<ListadoCentrosFestivosDto> getListadoCentrosFestivos() {

    return this.beanMapper.mapList(this.centerService.listadoCentrosFestivos(), ListadoCentrosFestivosDto.class);
  }

}
