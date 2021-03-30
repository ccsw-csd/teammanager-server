package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.coedevon.teammanager.group.model.GroupDto;
import com.capgemini.coedevon.teammanager.group.model.GroupEntity;
import com.capgemini.coedevon.teammanager.group.model.GroupManagerEntity;
import com.capgemini.coedevon.teammanager.group.model.GroupMemberEntity;
import com.capgemini.coedevon.teammanager.group.model.GroupSubgroupEntity;
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

  @Autowired
  GroupSubgroupRepository groupSubgroupRepository;

  @Autowired
  GroupManagerRepository groupManagerRepository;

  @Autowired
  GroupMemberRepository groupMemberRepository;

  @Override
  public List<GroupEntity> getSubgroups(String name) {

    return this.groupRepository.filtrarGrupos(name);
  }

  @Override
  public List<PersonEntity> getPersons(String name) {

    return this.personRepository.filtrarPersonas(name);
  }

  @Override
  public GroupEntity save(GroupDto data) {

    GroupEntity group = null;
    List<GroupSubgroupEntity> subgroups = null;
    List<GroupManagerEntity> managers = null;
    List<GroupMemberEntity> members = null;

    if (data.getId() != null)
      group = this.groupRepository.findById(data.getId()).orElse(null);
    else
      group = new GroupEntity();
    BeanUtils.copyProperties(data, group);
    managers = group.getManager();
    members = group.getMembers();
    subgroups = group.getSubgroups();

    System.out.print("\n Imprimimos group \n" + group.getName() + "\n" + group.getId() + "\n");
    this.groupRepository.save(group);
    this.groupSubgroupRepository.saveAll(subgroups);
    this.groupManagerRepository.saveAll(managers);
    this.groupMemberRepository.saveAll(members);

    return this.groupRepository.save(group);
  }
}
