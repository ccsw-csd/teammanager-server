package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.coedevon.teammanager.group.model.GroupEntity;

public interface GroupCustomRepository {
  @Query(value = "select * from `group` where name LIKE :prefix% LIMIT 15", nativeQuery = true)
  public List<GroupEntity> filtrarGrupos(@Param("prefix") String prefix);
}
