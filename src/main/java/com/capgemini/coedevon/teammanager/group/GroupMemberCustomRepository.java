package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupMemberCustomRepository {
  /**
   * @param id
   * @return
   */
  @Query(value = "select p from PersonEntity p where id in (select gmem.person_id from GroupMemberEntity gmem where gmem.group_id = :id)")
  public List<PersonEntity> filtrarMiembrosDelGrupo(@Param("id") long id);

  /**
   * @param id
   */
  @Modifying
  @Query(value = "delete from GroupMemberEntity where group_id = :id")
  void deleteAllById(Long id);
}