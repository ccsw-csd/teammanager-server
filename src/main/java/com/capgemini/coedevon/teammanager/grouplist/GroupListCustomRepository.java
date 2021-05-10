package com.capgemini.coedevon.teammanager.grouplist;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.coedevon.teammanager.grouplist.model.GroupListEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupListCustomRepository {
  /**
   * @param pageable
   * @param username
   * @return
   */
  @Query(value = "select * from v_group_list vgl where id in (select gm.group_id from group_manager gm join person p on gm.person_id = p.id where p.username = :username) or id in (select g.group_id from public_group g where g.username = :username)", nativeQuery = true)
  public Page<GroupListEntity> filtrarGestor(org.springframework.data.domain.Pageable pageable,
      @Param("username") String username);

  /**
   * @param pageable
   * @param username
   * @return
   */
  @Query(value = "select * from v_group_list vgl where id in (select g.group_id from public_group g where g.username = :username)", nativeQuery = true)
  public Page<GroupListEntity> filtrarGruposPublicos(org.springframework.data.domain.Pageable pageable,
      @Param("username") String username);
}
