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
public interface GroupManagerCustomRepository {
  /**
   * @param id
   * @return
   */
  @Query(value = "select p from PersonEntity p where p.id in (select gman.person_id from GroupManagerEntity gman where gman.group_id = :id)")
  public List<PersonEntity> filtrarManagersDelGrupo(@Param("id") long id);

  /**
   * @param id
   */
  @Modifying
  @Query(value = "delete from GroupManagerEntity where group_id = :id")
  void deleteAllById(Long id);
}
