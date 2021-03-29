package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.coedevon.teammanager.group.model.GroupEntity;
import com.capgemini.coedevon.teammanager.person.PersonRepository;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

  @Autowired
  PersonRepository personRepository;

  @Autowired
  GroupRepository groupRepository;

  @Override
  public List<GroupEntity> getSubgroups(String name) {

    return this.groupRepository.filtrarGrupos(name);
  }

  @Override
  public List<PersonEntity> getPersons(String name) {

    return this.personRepository.filtrarPersonas(name);
  }

}
