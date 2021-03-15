package com.capgemini.coedevon.teammanager.grouplist.model;

import java.util.List;

/**
 * TODO apastorm This type ...
 *
 */
public class GroupListDto {
  private Long id;

  private String name;

  private List<String> managers;

  private List<String> users;

  private List<String> subgroups;

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
  public List<String> getManagers() {

    return this.managers;
  }

  /**
   * @param managers new value of {@link #getmanagers}.
   */
  public void setManagers(List<String> managers) {

    this.managers = managers;
  }

  /**
   * @return users
   */
  public List<String> getUsers() {

    return this.users;
  }

  /**
   * @param users new value of {@link #getusers}.
   */
  public void setUsers(List<String> users) {

    this.users = users;
  }

  /**
   * @return subgroups
   */
  public List<String> getSubgroups() {

    return this.subgroups;
  }

  /**
   * @param subgroups new value of {@link #getsubgroups}.
   */
  public void setSubgroups(List<String> subgroups) {

    this.subgroups = subgroups;
  }

}
