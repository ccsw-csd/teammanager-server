package com.ccsw.teammanager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.config.security.UserInfoAppDto;
import com.ccsw.teammanager.config.security.UserUtils;
import com.ccsw.teammanager.group.GroupService;
import com.ccsw.teammanager.group.model.PublicGroupEntity;
import com.ccsw.teammanager.person.PersonService;
import com.ccsw.teammanager.person.model.PersonEntity;
import com.ccsw.teammanager.user.model.UserDto;

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
                    if (!dto.getRole().contains("GESTOR") && !dto.getRole().contains("ADMIN"))
                        dto.addRole("GESTOR");
                }
            }

        return dto;

    }

}
