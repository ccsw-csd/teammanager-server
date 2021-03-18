package com.capgemini.coedevon.teammanager.grouplist;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capgemini.coedevon.teammanager.config.security.UserUtils;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupListDto;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupListEntity;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupListSearchDto;

/**
 *
 *
 */
@Service
@Transactional
public class GroupListServiceImpl implements GroupListService {

  @Autowired
  GroupListRepository groupListRepository;

  @Override
  public Page<GroupListEntity> findPage(GroupListSearchDto dto) {

    Page<GroupListEntity> page = null;

    if (UserUtils.getUserDetails().getRole().equalsIgnoreCase("ADMIN")) {
      page = this.groupListRepository.findAll(dto.getPageable());
    } else if (UserUtils.getUserDetails().getRole().equalsIgnoreCase("GESTOR")) {
      page = this.groupListRepository.filtrarGestor(dto.getPageable(), UserUtils.getUserDetails().getUsername());
    }
    return page;
  }

  @Override
  public GroupListEntity save(GroupListDto data) {

    GroupListEntity groupList = null;
    if (data.getId() != null)
      groupList = this.groupListRepository.findById(data.getId()).orElse(null);
    else
      groupList = new GroupListEntity();

    BeanUtils.copyProperties(data, groupList);

    return this.groupListRepository.save(groupList);
  }
}
