package com.capgemini.coedevon.teammanager.groupList.model;

import java.util.List;

/**
 * TODO apastorm This type ...
 *
 */
public class GroupListDto {
  private int id;

  private String name;

  private List<String> managers;

  private List<String> usuarios;

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

    return this.usuarios;
  }

  /**
   * @param usuarios new value of {@link #getusuarios}.
   */
  public void setUsuarios(List<String> usuarios) {

    this.usuarios = usuarios;
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
