package com.capgemini.coedevon.teammanager.config.security;

import java.util.Date;

import org.springframework.security.core.Authentication;

/**
 * Class to store user information which is later encapsulated into {@link Authentication} object.
 *
 */
public class UserInfoAppDto extends UserInfoDto {

  private String role;

  private Date expiration;

  /**
   * @return role
   */
  public String getRole() {

    return this.role;
  }

  /**
   * @param role new value of {@link #getrole}.
   */
  public void setRole(String role) {

    this.role = role;
  }

  /**
   * @return expiration
   */
  public Date getExpiration() {

    return expiration;
  }

  /**
   * @param expiration new value of {@link #getexpiration}.
   */
  public void setExpiration(Date expiration) {

    this.expiration = expiration;
  }

}
