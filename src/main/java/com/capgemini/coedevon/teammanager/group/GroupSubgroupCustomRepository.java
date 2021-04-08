package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.coedevon.teammanager.group.model.GroupEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupSubgroupCustomRepository {
  /**
   * @param id
   * @return
   */
  @Query(value = "select sg from GroupEntity sg where sg.id in (select gsub.group_id from GroupSubgroupEntity gsub where gsub.group_id = :id)")
  public List<GroupEntity> filtrarSubgruposDelGrupo(@Param("id") long id);

  /**
   * @param id
   */
  @Modifying
  @Query(value = "delete from GroupSubgroupEntity where group_id = :id")
  void deleteAllById(Long id);
}
