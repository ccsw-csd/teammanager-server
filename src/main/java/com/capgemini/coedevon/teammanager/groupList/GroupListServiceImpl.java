package com.capgemini.coedevon.teammanager.groupList;

import java.util.List;

import com.capgemini.coedevon.teammanager.groupList.model.GroupListEntity;

/**
 *
 *
 */
public class GroupListServiceImpl implements GroupListService {

  GroupListRepository groupListRepository;

  @Override
  public List<GroupListEntity> getGroups() {

    return this.groupListRepository.findAllGroupsWithJpql();
  }
}
