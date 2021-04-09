package com.capgemini.coedevon.teammanager.group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.coedevon.teammanager.group.model.GroupManagerEntity;

/**
 * TODO apastorm This type ...
 *
 */
@Repository
public interface GroupManagerRepository extends CrudRepository<GroupManagerEntity, Long>, GroupManagerCustomRepository {

}
