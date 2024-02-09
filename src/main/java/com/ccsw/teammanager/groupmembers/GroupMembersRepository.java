package com.ccsw.teammanager.groupmembers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.teammanager.groupmembers.model.GroupMembersEntity;

/**
*
*/
public interface GroupMembersRepository extends CrudRepository<GroupMembersEntity, Long> {

    List<GroupMembersEntity> findByGroupId(Long groupId);
}
