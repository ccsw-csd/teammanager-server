package com.capgemini.coedevon.teammanager.releasenote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "release_user")
public class ReleaseUserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "last_read", nullable = false)
  private Long lastReadId;

  /**
   * @return the id
   */
  public Long getId() {

    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {

    this.id = id;
  }

  /**
   * @return the username
   */
  public String getUsername() {

    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {

    this.username = username;
  }

  /**
   * @return the lastReadId
   */
  public Long getLastReadId() {

    return lastReadId;
  }

  /**
   * @param lastReadId the lastReadId to set
   */
  public void setLastReadId(Long lastReadId) {

    this.lastReadId = lastReadId;
  }

}
