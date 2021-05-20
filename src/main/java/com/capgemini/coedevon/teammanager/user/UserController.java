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
import com.capgemini.coedevon.teammanager.person.PersonService;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;
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
  private PersonService personService;

  @Autowired
  private BeanMapper beanMapper;

  /**
   * Recupera el usuario logado
   *
   * @return
   */
  @RequestMapping(path = "/", method = RequestMethod.GET)
  public UserDto get() {

    UserInfoAppDto userDetails = UserUtils.getUserDetails();
    UserDto dto = this.beanMapper.map(userDetails, UserDto.class);

    List<PublicGroupEntity> publicGroups = this.groupService.findPublicGroupsFromConnectedUser();
    dto.setWithPublicGroups(publicGroups != null && publicGroups.size() > 0);

    PersonEntity person = this.personService.getManager(userDetails.getUsername());
    if (person != null)
      if (person.getGrade() != null) {
        if (person.getGrade().equals("D") || person.getGrade().equals("E") || person.getGrade().equals("F")) {
          if (!dto.getRole().equals("GESTOR") && !dto.getRole().equals("ADMIN"))
            dto.setRole("GESTOR");
        }
      }

    return dto;

  }

}
