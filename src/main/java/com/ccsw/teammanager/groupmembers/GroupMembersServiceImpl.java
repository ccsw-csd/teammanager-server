package com.ccsw.teammanager.groupmembers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccsw.teammanager.groupmembers.model.GroupMembersEntity;

public class GroupMembersServiceImpl implements GroupMembersService {

    @Autowired
    GroupMembersRepository groupMembersRepository;

    @Override
    public List<GroupMembersEntity> findByGroupId(Long group_id) {
        return groupMembersRepository.findByGroupId(group_id);
    }

}
