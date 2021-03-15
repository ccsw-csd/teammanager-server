package com.capgemini.coedevon.teammanager.grouplist.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author apastorm
 *
 */
@Entity
@Table(name = "v_group_list")
public class GroupListEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @ElementCollection(targetClass = Integer.class)
  @Column(name = "managers")
  private List<Integer> managers;

  @ElementCollection(targetClass = Integer.class)
  @Column(name = "users")
  private List<Integer> users;

  @ElementCollection(targetClass = Integer.class)
  @Column(name = "subgroups")
  private List<Integer> subgroups;

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
  public List<Integer> getManagers() {

    return this.managers;
  }

  /**
   * @param managers new value of {@link #getmanagers}.
   */
  public void setManagers(List<Integer> managers) {

    this.managers = managers;
  }

  /**
   * @return users
   */
  public List<Integer> getUsers() {

    return this.users;
  }

  /**
   * @param users new value of {@link #getusers}.
   */
  public void setUsers(List<Integer> users) {

    this.users = users;
  }

  /**
   * @return subgroups
   */
  public List<Integer> getSubgroups() {

    return this.subgroups;
  }

  /**
   * @param subgroups new value of {@link #getsubgroups}.
   */
  public void setSubgroups(List<Integer> subgroups) {

    this.subgroups = subgroups;
  }

}
