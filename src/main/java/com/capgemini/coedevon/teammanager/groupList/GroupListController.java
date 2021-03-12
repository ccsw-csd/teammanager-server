package com.capgemini.coedevon.teammanager.groupList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.groupList.model.GroupListDto;

@RequestMapping(value = "/groupList")
@RestController
public class GroupListController {

  @Autowired
  private BeanMapper beanMapper;

  @Autowired
  private GroupListService groupListService;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public List<GroupListDto> getGroups() {

    return this.beanMapper.mapList(this.groupListService.getGroups(), GroupListDto.class);
  }
}
