package com.ccsw.teammanager.groupmembers;

import java.time.LocalDateTime;
import java.util.List;

import com.ccsw.teammanager.groupmembers.model.Detail;
import com.ccsw.teammanager.groupmembers.model.GroupMembersEntity;

public interface GroupMembersService {

    List<GroupMembersEntity> findByGroupId(Long groupId);

    List<Detail> findDetails(Long groupId, LocalDateTime startDate, LocalDateTime endDate);

}
