package com.capgemini.coedevon.teammanager.group;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.group.model.GroupSubgroupEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupSubgroupRepository
    extends CrudRepository<GroupSubgroupEntity, Long>, GroupSubgroupCustomRepository {

}
