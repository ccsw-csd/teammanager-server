package com.capgemini.coedevon.teammanager.groupList.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
  @Column(name = "id", nullable = false)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "managers")
  private List<String> managers;

  @Column(name = "users")
  private List<String> users;

  @Column(name = "subgroups")
  private List<String> subgrupos;

  /**
   * @return id
   */
  public int getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getid}.
   */
  public void setId(int id) {

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
   * @return usuarios
   */
  public List<String> getUsuarios() {

    return this.users;
  }

  /**
   * @param usuarios new value of {@link #getusuarios}.
   */
  public void setUsuarios(List<String> users) {

    this.users = users;
  }

  /**
   * @return subgrupos
   */
  public List<String> getSubgrupos() {

    return this.subgrupos;
  }

  /**
   * @param subgrupos new value of {@link #getsubgrupos}.
   */
  public void setSubgrupos(List<String> subgrupos) {

    this.subgrupos = subgrupos;
  }
}
