package com.ccsw.teammanager.groupmembers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.groupmembers.model.Detail;
import com.ccsw.teammanager.groupmembers.model.GroupMembersDto;

@RequestMapping(value = "/group_members")
@RestController
public class GroupMembersController {

    @Autowired
    private GroupMembersService groupMembersService;

    /**
     * Método para recuperar registros a partir del group_id
     *
     * @return {@link List} de {@link GroupMembersDto}
     */

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Detail> findDetailsMembers(@RequestParam(name = "group_id", required = true) Long groupId,
            @RequestParam(name = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(name = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        List<Detail> details = this.groupMembersService.findDetails(groupId, startDate, endDate);

        return details;
    }

}
