package com.capgemini.coedevon.teammanager.groupList;

import java.util.List;

import com.capgemini.coedevon.teammanager.groupList.model.GroupListEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupListService {
  /**
   * @return Lista de grupos con id, nombre, managers, usuarios, subgrupos
   */
  List<GroupListEntity> getGroups();
}
