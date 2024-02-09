package com.ccsw.teammanager.groupmembers.model;

public class GroupMembersDto {

    private String id;

    private Long groupId;

    private Long personId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroup_id(Long groupId) {
        this.groupId = groupId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

}
