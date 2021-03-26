package com.capgemini.coedevon.teammanager.grouplist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupDto;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupListDto;
import com.capgemini.coedevon.teammanager.grouplist.model.GroupListSearchDto;
import com.capgemini.coedevon.teammanager.person.PersonService;
import com.capgemini.coedevon.teammanager.person.model.PersonDto;

@RequestMapping(value = "/grouplist")
@RestController
public class GroupListController {

  @Autowired
  private GroupListService groupListService;

  @Autowired
  private GroupService groupService;

  @Autowired
  private PersonService personService;

  @Autowired
  private BeanMapper beanMapper;

  @RequestMapping(path = "/", method = RequestMethod.POST)
  public Page<GroupListDto> findPage(@RequestBody GroupListSearchDto dto) {

    return this.beanMapper.mapPage(this.groupListService.findPage(dto), GroupListDto.class);
  }

  /**
   * @param name
   * @return
   */
  @RequestMapping(path = "/subgroups/", method = RequestMethod.POST)
  public List<GroupDto> getSubgroups(@RequestBody String name) {

    return this.beanMapper.mapList(this.groupService.getSubgroups(name), GroupDto.class);
  }

  /**
   * @param prefix
   * @return
   */
  @RequestMapping(path = "/persons/", method = RequestMethod.POST)
  public List<PersonDto> getPersons(@RequestBody String name) {

    return this.beanMapper.mapList(this.groupService.getPersons(name), PersonDto.class);
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
