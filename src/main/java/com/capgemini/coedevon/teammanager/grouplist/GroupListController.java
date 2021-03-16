package com.capgemini.coedevon.teammanager.grouplist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupListDto;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupListSearchDto;

@RequestMapping(value = "/grouplist")
@RestController
public class GroupListController {

  @Autowired
  private BeanMapper beanMapper;

  @Autowired
  private GroupListService groupListService;

  @RequestMapping(path = "/", method = RequestMethod.POST)
  public Page<GroupListDto> findPage(@RequestBody GroupListSearchDto dto) {

    return this.beanMapper.mapPage(this.groupListService.findPage(dto), GroupListDto.class);
  }

  /**
   * @param data
   * @return
   */
  @RequestMapping(path = "/", method = RequestMethod.PUT)
  public GroupListDto save(@RequestBody GroupListDto data) {

    return this.beanMapper.map(this.groupListService.save(data), GroupListDto.class);
  }
}
