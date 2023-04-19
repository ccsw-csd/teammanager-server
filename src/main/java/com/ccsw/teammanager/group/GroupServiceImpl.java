package com.ccsw.teammanager.group;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.group.model.EditGroupDto;
import com.ccsw.teammanager.group.model.GroupDto;
import com.ccsw.teammanager.group.model.GroupEntity;
import com.ccsw.teammanager.group.model.GroupManagerEntity;
import com.ccsw.teammanager.group.model.GroupMemberEntity;
import com.ccsw.teammanager.group.model.GroupSubgroupEntity;
import com.ccsw.teammanager.person.PersonRepository;
import com.ccsw.teammanager.person.model.PersonEntity;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupSubgroupRepository groupSubgroupRepository;

    @Autowired
    private GroupManagerRepository groupManagerRepository;

    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @Override
    public List<GroupEntity> getSubgroups(String name) {

        name = name.replaceAll(" ", "%");
        return this.groupRepository.findByName(name);
    }

    @Override
    public List<PersonEntity> getPersons(String name) {

        name = name.replaceAll(" ", "%");
        return this.personRepository.findByTextAndActive(name);
    }

    @Override
    @Transactional
    public GroupEntity save(GroupDto data) {
        if (data.getExternalId() != null) {
            return saveExternalGroup(data);
        }

        return saveInternalGroup(data);
    }

    @Override
    public EditGroupDto getGroup(long id) {

        EditGroupDto editGroup = new EditGroupDto();
        editGroup.setId(id);

        GroupEntity group = this.groupRepository.findById(id).get();

        editGroup.setName(group.getName());
        editGroup.setExternalId(group.getExternalId());
        editGroup.setPublicGroup(group.isPublicGroup());

        List<PersonEntity> managers = this.groupManagerRepository.findManagersByGroupId(id);
        List<PersonEntity> members = this.groupMemberRepository.findMembersByGroupId(id);
        List<GroupEntity> subgroups = this.groupSubgroupRepository.findSubgroupsByGroupId(id);

        editGroup.setManagers(managers);
        editGroup.setMembers(members);
        editGroup.setSubgroups(subgroups);

        return editGroup;
    }

    private GroupEntity saveInternalGroup(GroupDto data) {

        GroupEntity groupEntity = new GroupEntity();
        groupEntity = this.groupRepository.findById(data.getId()).orElse(null);
        groupEntity.setName(data.getName());

        this.groupManagerRepository.deleteByGroupId(data.getId());
        this.groupMemberRepository.deleteByGroupId(data.getId());
        this.groupSubgroupRepository.deleteByGroupId(data.getId());

        BeanUtils.copyProperties(data, groupEntity);
        this.groupRepository.save(groupEntity);

        for (int i = 0; i < data.getManagers().size(); i++) {
            GroupManagerEntity groupManagerEntity = new GroupManagerEntity();
            groupManagerEntity.setPerson_id(data.getManagers().get(i).getId());
            groupManagerEntity.setGroup_id(groupEntity.getId());
            this.groupManagerRepository.save(groupManagerEntity);
        }

        for (int i = 0; i < data.getMembers().size(); i++) {
            GroupMemberEntity groupMemberEntity = new GroupMemberEntity();
            groupMemberEntity.setMember_id(data.getMembers().get(i).getId());
            groupMemberEntity.setGroup_id(groupEntity.getId());
            this.groupMemberRepository.save(groupMemberEntity);
        }

        for (int i = 0; i < data.getSubgroups().size(); i++) {
            GroupSubgroupEntity groupSubgroupEntity = new GroupSubgroupEntity();
            groupSubgroupEntity.setSubgroup_id(data.getSubgroups().get(i).getId());
            groupSubgroupEntity.setGroup_id(groupEntity.getId());
            this.groupSubgroupRepository.save(groupSubgroupEntity);
        }

        return groupEntity;
    }

    private GroupEntity saveExternalGroup(GroupDto data) {

        GroupEntity group = this.groupRepository.findById(data.getId()).orElse(null);
        group.setPublicGroup(data.getPublicGroup());

        this.groupRepository.save(group);

        return group;

    }

}
