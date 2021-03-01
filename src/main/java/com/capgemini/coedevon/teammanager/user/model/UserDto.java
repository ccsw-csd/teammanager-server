package com.capgemini.coedevon.teammanager.user.model;

/**
 * @author pajimene
 *
 */
public class UserDto {

  private String username;

  private String role;

  private String displayName;

  private String mail;

  private String lastName;

  private String firstName;

  /**
   * @return username
   */
  public String getUsername() {

    return this.username;
  }

  /**
   * @param username new value of {@link #getusername}.
   */
  public void setUsername(String username) {

    this.username = username;
  }

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
   * @return displayName
   */
  public String getDisplayName() {

    return this.displayName;
  }

  /**
   * @param displayName new value of {@link #getdisplayName}.
   */
  public void setDisplayName(String displayName) {

    this.displayName = displayName;
  }

  /**
   * @return mail
   */
  public String getMail() {

    return this.mail;
  }

  /**
   * @param mail new value of {@link #getmail}.
   */
  public void setMail(String mail) {

    this.mail = mail;
  }

  /**
   * @return lastName
   */
  public String getLastName() {

    return this.lastName;
  }

  /**
   * @param lastName new value of {@link #getlastName}.
   */
  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  /**
   * @return firstName
   */
  public String getFirstName() {

    return this.firstName;
  }

  /**
   * @param firstName new value of {@link #getfirstName}.
   */
  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

}
