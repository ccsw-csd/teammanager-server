package com.capgemini.coedevon.teammanager.group;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.group.model.GroupMemberEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupMemberRepository extends CrudRepository<GroupMemberEntity, Long>, GroupMemberCustomRepository {

}
