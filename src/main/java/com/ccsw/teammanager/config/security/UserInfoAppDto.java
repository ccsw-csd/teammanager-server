package com.ccsw.teammanager.config.security;

import java.util.Date;

import org.springframework.security.core.Authentication;

/**
 * Class to store user information which is later encapsulated into {@link Authentication} object.
 *
 */
public class UserInfoAppDto extends UserInfoDto {

  private String role;

  private String jwt;

  private Date expiration;

  private boolean withPON;

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

    return this.expiration;
  }

  /**
   * @param expiration new value of {@link #getexpiration}.
   */
  public void setExpiration(Date expiration) {

    this.expiration = expiration;
  }

  /**
   * @return jwt
   */
  public String getJwt() {

    return this.jwt;
  }

  /**
   * @param jwt new value of {@link #getjwt}.
   */
  public void setJwt(String jwt) {

    this.jwt = jwt;
  }

  /**
   * @return withPON
   */
  public boolean isWithPON() {

    return withPON;
  }

  /**
   * @param withPON new value of {@link #getwithPON}.
   */
  public void setWithPON(boolean withPON) {

    this.withPON = withPON;
  }

}
