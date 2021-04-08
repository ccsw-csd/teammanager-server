package com.capgemini.coedevon.teammanager.group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.coedevon.teammanager.group.model.GroupEntity;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, Long>, GroupCustomRepository {
}
