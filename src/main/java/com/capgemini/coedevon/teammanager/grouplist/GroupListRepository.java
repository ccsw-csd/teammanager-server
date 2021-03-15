package com.capgemini.coedevon.teammanager.grouplist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.grouplist.model.GroupListEntity;

public interface GroupListRepository extends CrudRepository<GroupListEntity, Long> {
  /**
   * @return Returns the view v_group_list id name managers users subgroups
   */
  Page<GroupListEntity> findAll(Pageable page);
}
