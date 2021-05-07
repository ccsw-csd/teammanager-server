package com.capgemini.coedevon.teammanager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.config.security.UserInfoAppDto;
import com.capgemini.coedevon.teammanager.config.security.UserUtils;
import com.capgemini.coedevon.teammanager.group.GroupService;
import com.capgemini.coedevon.teammanager.group.model.PublicGroupEntity;
import com.capgemini.coedevon.teammanager.user.model.UserDto;

/**
 * @author pajimene
 *
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

  @Autowired
  private GroupService groupService;

  @Autowired
  private BeanMapper beanMapper;

  /**
   * Recupera el usuario logado
   * @return
   */
  @RequestMapping(path = "/", method = RequestMethod.GET)
  public UserDto get() {

    UserInfoAppDto userDetails = UserUtils.getUserDetails();
    UserDto dto = this.beanMapper.map(userDetails, UserDto.class);

    List<PublicGroupEntity> publicGroups = groupService.findPublicGroupsFromConnectedUser();
    dto.setWithPublicGroups(publicGroups != null && publicGroups.size() > 0);

    return dto;

  }

}
