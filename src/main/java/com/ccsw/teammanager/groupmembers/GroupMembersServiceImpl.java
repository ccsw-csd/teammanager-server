package com.ccsw.teammanager.groupmembers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.groupmembers.model.GroupMembersEntity;

@Service
@Transactional
public class GroupMembersServiceImpl implements GroupMembersService {

    @Autowired
    GroupMembersRepository groupMembersRepository;

    @Override
    public List<GroupMembersEntity> findByGroupId(Long group_id) {
        return groupMembersRepository.findByGroupId(group_id);
    }

}
