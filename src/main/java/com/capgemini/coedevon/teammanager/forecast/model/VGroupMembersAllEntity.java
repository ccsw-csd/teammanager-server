package com.capgemini.coedevon.teammanager.forecast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.coedevon.teammanager.group.model.GroupEntity;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * @author pajimene
 *
 */
@Entity
@Table(name = "v_group_members_all")
public class VGroupMembersAllEntity {

  @Id
  @Column(name = "id")
  private String id;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private GroupEntity group;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private PersonEntity person;

  /**
   * @return id
   */
  public String getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getid}.
   */
  public void setId(String id) {

    this.id = id;
  }

  /**
   * @return group
   */
  public GroupEntity getGroup() {

    return this.group;
  }

  /**
   * @param group new value of {@link #getgroup}.
   */
  public void setGroup(GroupEntity group) {

    this.group = group;
  }

  /**
   * @return person
   */
  public PersonEntity getPerson() {

    return this.person;
  }

  /**
   * @param person new value of {@link #getperson}.
   */
  public void setPerson(PersonEntity person) {

    this.person = person;
  }

}
