package com.ccsw.teammanager.grouplist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.group.GroupService;
import com.ccsw.teammanager.group.model.EditGroupDto;
import com.ccsw.teammanager.group.model.GroupDto;
import com.ccsw.teammanager.grouplist.model.GroupListDto;
import com.ccsw.teammanager.person.model.PersonDto;

@RequestMapping(value = "/grouplist")
@RestController
public class GroupListController {

    @Autowired
    private GroupListService groupListService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private BeanMapper beanMapper;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<GroupListDto> findAll(@RequestParam(defaultValue = "false", value = "adminView") boolean adminView) {

        return this.beanMapper.mapList(this.groupListService.findAll(adminView), GroupListDto.class);
    }

    /**
     * @param name
     * @return
     */
    @RequestMapping(path = "/subgroups/", method = RequestMethod.POST)
    public List<GroupDto> getSubgroups(@RequestBody String name) {

        return this.beanMapper.mapList(this.groupService.getSubgroups(name), GroupDto.class);
    }

    /**
     * @param name
     * @return
     */
    @RequestMapping(path = "/editgroup/{id}", method = RequestMethod.GET)
    public EditGroupDto getGroup(@PathVariable Long id) {

        return this.beanMapper.map(this.groupService.getGroup(id), EditGroupDto.class);
    }

    /**
     * @param prefix
     * @return
     */
    @RequestMapping(path = "/persons/", method = RequestMethod.POST)
    public List<PersonDto> getPersons(@RequestBody String name) {

        return this.beanMapper.mapList(this.groupService.getPersons(name), PersonDto.class);
    }

    /**
     * @param data
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public GroupDto save(@RequestBody GroupDto data) {

        return this.beanMapper.map(this.groupService.save(data), GroupDto.class);
    }

}
