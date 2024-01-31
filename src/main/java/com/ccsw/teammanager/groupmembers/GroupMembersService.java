package com.ccsw.teammanager.groupmembers;

import java.util.List;

import com.ccsw.teammanager.groupmembers.model.GroupMembersEntity;

public interface GroupMembersService {

    List<GroupMembersEntity> findByGroupId(Long groupId);

}
