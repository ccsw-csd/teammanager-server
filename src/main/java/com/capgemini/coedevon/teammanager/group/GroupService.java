package com.capgemini.coedevon.teammanager.grouplist;

import java.util.List;

import com.capgemini.coedevon.teammanager.grouplist.model.GroupEntity;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupService {
  /**
   * @param inicioNombre
   * @return
   */
  List<GroupEntity> getSubgroups(String name);

  List<PersonEntity> getPersons(String name);

}
