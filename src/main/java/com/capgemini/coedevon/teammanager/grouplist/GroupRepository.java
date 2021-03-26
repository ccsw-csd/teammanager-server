package com.capgemini.coedevon.teammanager.grouplist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.coedevon.teammanager.grouplist.model.GroupEntity;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, Long> {

  List<GroupEntity> findByName(String name);

  @Override
  List<GroupEntity> findAll();

  List<GroupEntity> findByNameContaining(String name);

  List<GroupEntity> findByNameContains(String name);

  List<GroupEntity> findByNameIsContaining(String name);

  List<GroupEntity> findByNameLike(String name);

  List<GroupEntity> findByNameStartingWith(String name);

  List<GroupEntity> findByNameIgnoreCase(String name);

  List<GroupEntity> findByNameContainingIgnoreCase(String name);

  List<GroupEntity> findByNameContainsIgnoreCase(String name);

  List<GroupEntity> findByNameIsContainingIgnoreCase(String name);

  List<GroupEntity> findByNameLikeIgnoreCase(String name);

  List<GroupEntity> findByNameStartingWithIgnoreCase(String name);
}
