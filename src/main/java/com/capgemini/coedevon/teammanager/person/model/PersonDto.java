package com.capgemini.coedevon.teammanager.person.model;

/**
 * @author aolmosca
 *
 */
public class PersonDto {
  private String id;

  private String saga;

  private String username;

  private String email;

  private String name;

  private String lastname;

  private Integer center_id;

  private String businesscode;

  private Integer active;

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
   * @return saga
   */
  public String getSaga() {

    return this.saga;
  }

  /**
   * @param saga new value of {@link #getsaga}.
   */
  public void setSaga(String saga) {

    this.saga = saga;
  }

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
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getemail}.
   */
  public void setEmail(String email) {

    this.email = email;
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
   * @return lastname
   */
  public String getLastname() {

    return this.lastname;
  }

  /**
   * @param lastname new value of {@link #getlastname}.
   */
  public void setLastname(String lastname) {

    this.lastname = lastname;
  }

  /**
   * @return center_id
   */
  public Integer getCenter_id() {

    return this.center_id;
  }

  /**
   * @param center_id new value of {@link #getcenter_id}.
   */
  public void setCenter_id(Integer center_id) {

    this.center_id = center_id;
  }

  /**
   * @return businesscode
   */
  public String getBusinesscode() {

    return this.businesscode;
  }

  /**
   * @param businesscode new value of {@link #getbusinesscode}.
   */
  public void setBusinesscode(String businesscode) {

    this.businesscode = businesscode;
  }

  /**
   * @return active
   */
  public Integer getActive() {

    return this.active;
  }

  /**
   * @param active new value of {@link #getactive}.
   */
  public void setActive(Integer active) {

    this.active = active;
  }

}
