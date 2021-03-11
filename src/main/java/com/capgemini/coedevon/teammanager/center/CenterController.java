package com.capgemini.coedevon.teammanager.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.center.model.CenterDto;
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

  @RequestMapping(path = "/getAll/", method = RequestMethod.GET)
  public List<CenterDto> get() {

    return this.centerService.getAllCenters();

  }

}
