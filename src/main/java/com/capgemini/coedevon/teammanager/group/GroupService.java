package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import com.capgemini.coedevon.teammanager.group.model.EditGroup;
import com.capgemini.coedevon.teammanager.group.model.GroupDto;
import com.capgemini.coedevon.teammanager.group.model.GroupEntity;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupService {

  EditGroup getGroup(long id);

  /**
   * @param inicioNombre
   * @return
   */
  List<GroupEntity> getSubgroups(String name);

  List<PersonEntity> getPersons(String name);

  /**
   * @param data
   * @return
   */
  GroupEntity save(GroupDto data);

}
