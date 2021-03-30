package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.group.model.GroupDto;
import com.capgemini.coedevon.teammanager.group.model.GroupEntity;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupService extends CrudRepository<GroupEntity, Long>{
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
