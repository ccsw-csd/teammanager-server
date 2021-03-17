package com.capgemini.coedevon.teammanager.grouplist;

import java.awt.print.Pageable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.coedevon.teammanager.grouplist.model.GroupListEntity;

/**
 * TODO apastorm This type ...
 *
 */
public class GroupListCustomRepositoryImpl implements GroupListCustomRepository {

  @Autowired
  private EntityManager entityManager;

  @Override
  @Query(value = "select * from v_group_list vgl where id in (select gm.group_id from group_manager gm join person p on gm.person_id = p.id where p.username = :username)")
  abstract
  Page<GroupListEntity> findAllGroupListWithPagination(Pageable pageable, String username);

}
