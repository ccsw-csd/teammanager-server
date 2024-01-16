package com.ccsw.teammanager.groupmembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.groupmembers.model.GroupMembersDto;

@RequestMapping(value = "/v_group_members_all")
@RestController
@CrossOrigin(origins = "*")
public class GroupMembersController {

    @Autowired
    private GroupMembersService groupMembersService;

    @Autowired
    private BeanMapper beanMapper;

    /**
     * Método para recuperar registros a partir del group_id
     *
     * @return {@link List} de {@link GroupMembersDto}
     */

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<GroupMembersDto> findByGroupId(@RequestParam(name = "group_id", required = true) Long group_id) {
        return this.beanMapper.mapList(this.groupMembersService.findByGroupId(group_id), GroupMembersDto.class);
    }
}
