package com.capgemini.coedevon.teammanager.groupList;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.capgemini.coedevon.teammanager.groupList.model.GroupListEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupListRepository {
  /**
   * @return Returns the view v_group_list id name managers users subgroups
   */
  @Query("SELECT gl FROM v_group_list gl")
  List<GroupListEntity> findAllGroupsWithJpql();
}
