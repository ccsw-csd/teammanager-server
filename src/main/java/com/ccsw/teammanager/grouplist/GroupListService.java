package com.ccsw.teammanager.grouplist;

import org.springframework.data.domain.Page;

import com.ccsw.teammanager.grouplist.model.GroupListEntity;
import com.ccsw.teammanager.grouplist.model.GroupListSearchDto;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupListService {
  /**
   * @return Lista de grupos con id, name, manager, members, subgroups
   */
  Page<GroupListEntity> findPage(GroupListSearchDto dto);

  Page<GroupListEntity> findPageManager(GroupListSearchDto dto);

  /**
   * @param data
   * @return
   */
}
