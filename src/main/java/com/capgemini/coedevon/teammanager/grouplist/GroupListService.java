package com.capgemini.coedevon.teammanager.grouplist;

import org.springframework.data.domain.Page;

import com.capgemini.coedevon.teammanager.grouplist.model.GroupListEntity;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupListSearchDto;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupListService {
  /**
   * @return Lista de grupos con id, name, manager, members, subgroups
   */
  Page<GroupListEntity> findPage(GroupListSearchDto dto);

  /**
   * @param data
   * @return
   */
}
