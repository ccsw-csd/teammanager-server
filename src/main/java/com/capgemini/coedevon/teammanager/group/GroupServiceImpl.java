package com.capgemini.coedevon.teammanager.group;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.coedevon.teammanager.group.model.EditGroup;
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

    GroupEntity group = new GroupEntity();
    ArrayList<GroupManagerEntity> managersGuardados = new ArrayList<GroupManagerEntity>();
    ArrayList<GroupMemberEntity> membersGuardados = new ArrayList<GroupMemberEntity>();
    ArrayList<GroupSubgroupEntity> subgroupsGuardados = new ArrayList<GroupSubgroupEntity>();

    if (data.getId() != null) {
      group = this.groupRepository.findById(data.getId()).orElse(null);
      group.setName(data.getName());
      this.groupManagerRepository.deleteAllById(data.getId());
      this.groupMemberRepository.deleteAllById(data.getId());
      if (this.groupSubgroupRepository.findById(data.getId()) != null)
        this.groupSubgroupRepository.deleteAllById(data.getId());
    }

    BeanUtils.copyProperties(data, group);

    this.groupRepository.save(group);

    for (int i = 0; i < data.getManagers().size(); i++) {
      GroupManagerEntity groupManager = new GroupManagerEntity();
      groupManager.setPerson_id(data.getManagers().get(i).getId());
      groupManager.setGroup_id(group.getId());
      if (!managersGuardados.contains(groupManager))
        this.groupManagerRepository.save(groupManager);
      managersGuardados.add(groupManager);
    }
    if (data.getMembers() != null) {
      for (int i = 0; i < data.getMembers().size(); i++) {
        GroupMemberEntity groupMember = new GroupMemberEntity();
        groupMember.setMember_id(data.getMembers().get(i).getId());
        groupMember.setGroup_id(group.getId());
        if (!membersGuardados.contains(groupMember))
          this.groupMemberRepository.save(groupMember);
        membersGuardados.add(groupMember);
      }
    }
    if (data.getSubgroups() != null) {
      for (int i = 0; i < data.getSubgroups().size(); i++) {
        GroupSubgroupEntity groupSubgroups = new GroupSubgroupEntity();
        groupSubgroups.setSubgroup_id(data.getSubgroups().get(i).getId());
        groupSubgroups.setGroup_id(group.getId());
        if (!subgroupsGuardados.contains(groupSubgroups))
          this.groupSubgroupRepository.save(groupSubgroups);
        subgroupsGuardados.add(groupSubgroups);
      }
    }
    return group;
  }

  @Override
  public EditGroup getGroup(long id) {

    EditGroup editGroup = new EditGroup();
    editGroup.setId(id);
    editGroup.setName(this.groupRepository.findById(id).get().getName());

    List<PersonEntity> managers = this.groupManagerRepository.filtrarManagersDelGrupo(id);
    List<PersonEntity> members = this.groupMemberRepository.filtrarMiembrosDelGrupo(id);
    List<GroupEntity> subgroups = this.groupSubgroupRepository.filtrarSubgruposDelGrupo(id);

    editGroup.setManagers(managers);
    editGroup.setMembers(members);
    editGroup.setSubgroups(subgroups);

    return editGroup;
  }
}
