package com.capgemini.coedevon.teammanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.config.security.UserInfoAppDto;
import com.capgemini.coedevon.teammanager.config.security.UserUtils;
import com.capgemini.coedevon.teammanager.user.model.UserDto;

/**
 * @author pajimene
 *
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

  @Autowired
  private BeanMapper beanMapper;

  /**
   * Recupera el usuario logado
   * @return
   */
  @RequestMapping(path = "/", method = RequestMethod.GET)
  public UserDto get() {

    UserInfoAppDto userDetails = UserUtils.getUserDetails();

    return this.beanMapper.map(userDetails, UserDto.class);

  }

}
