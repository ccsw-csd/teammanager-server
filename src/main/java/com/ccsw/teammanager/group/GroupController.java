package com.ccsw.teammanager.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.group.dto.EditGroupDto;
import com.ccsw.teammanager.group.dto.GroupDto;
import com.ccsw.teammanager.group.dto.GroupListDto;

@RequestMapping(value = "/group")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private BeanMapper beanMapper;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<GroupListDto> findAll(@RequestParam(defaultValue = "false", value = "adminView") boolean adminView) {

        return this.beanMapper.mapList(this.groupService.findAll(adminView), GroupListDto.class);
    }

    /**
     * @param name
     * @return
     */
    @RequestMapping(path = "/find/{name}", method = RequestMethod.GET)
    public List<GroupDto> getSubgroups(@PathVariable String name) {

        return this.beanMapper.mapList(this.groupService.getSubgroups(name), GroupDto.class);
    }

    /**
     * @param name
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public EditGroupDto getGroup(@PathVariable Long id) {

        return this.beanMapper.map(this.groupService.getGroup(id), EditGroupDto.class);
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
