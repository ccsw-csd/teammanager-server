package com.capgemini.coedevon.teammanager.group.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
@Entity
@Table(name = "`group`")
public class GroupEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "manager")
  private List<PersonEntity> manager;

  @Column(name = "member")
  private List<PersonEntity> members;

  @Column(name = "subgroup", nullable = true)
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
   * @return manager
   */
  public List<PersonEntity> getManager() {

    return this.manager;
  }

  /**
   * @param manager new value of {@link #getmanager}.
   */
  public void setManager(List<PersonEntity> manager) {

    this.manager = manager;
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