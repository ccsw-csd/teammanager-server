package com.capgemini.coedevon.teammanager.group.model;

import java.util.List;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
public class EditGroup {
  private Long id;

  private String name;

  private List<PersonEntity> managers;

  private List<PersonEntity> members;

  private List<GroupEntity> subgroups;

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

  /**
   * @return managers
   */
  public List<PersonEntity> getManagers() {

    return this.managers;
  }

  /**
   * @param managers new value of {@link #getmanagers}.
   */
  public void setManagers(List<PersonEntity> managers) {

    this.managers = managers;
  }

  /**
   * @return members
   */
  public List<PersonEntity> getMembers() {

    return this.members;
  }

  /**
   * @param members new value of {@link #getmembers}.
   */
  public void setMembers(List<PersonEntity> members) {

    this.members = members;
  }

  /**
   * @return subgroups
   */
  public List<GroupEntity> getSubgroups() {

    return this.subgroups;
  }

  /**
   * @param subgroups new value of {@link #getsubgroups}.
   */
  public void setSubgroups(List<GroupEntity> subgroups) {

    this.subgroups = subgroups;
  }

}
