package com.capgemini.coedevon.teammanager.group.model;

import java.util.List;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
public class GroupDto {

  private Long id;

  private String name;

  private List<GroupEntity> members;

  private List<PersonEntity> managers;

  private List<GroupEntity> subgroups;

  /**
   * @return members
   */
  public List getMembers() {

    return this.members;
  }

  /**
   * @param members new value of {@link #getmembers}.
   */
  public void setMembers(List members) {

    this.members = members;
  }

  /**
   * @return managers
   */
  public List getManagers() {

    return this.managers;
  }

  /**
   * @param managers new value of {@link #getmanagers}.
   */
  public void setManagers(List managers) {

    this.managers = managers;
  }

  /**
   * @return subgroups
   */
  public List getSubgroups() {

    return this.subgroups;
  }

  /**
   * @param subgroups new value of {@link #getsubgroups}.
   */
  public void setSubgroups(List subgroups) {

    this.subgroups = subgroups;
  }

  /**
   * @return id
   */
  public Long getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getid}.
   */
  public void setId(Long id) {

    this.id = id;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }
}
