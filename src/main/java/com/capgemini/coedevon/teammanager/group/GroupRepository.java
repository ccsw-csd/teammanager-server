package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.coedevon.teammanager.group.model.GroupEntity;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, Long> {
  @Query(value = "select * from `group` where name LIKE :prefix% LIMIT 15", nativeQuery = true)
  public List<GroupEntity> filtrarGrupos(@Param("prefix") String prefix);
}
