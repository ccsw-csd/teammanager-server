package com.capgemini.coedevon.teammanager.person.model;

/**
 * @author aolmosca
 *
 */
public class PersonInconsistencyDto {
  private String saga;

  private String username;

  private String name;

  private String lastname;

  private Integer centerId;

  private String businesscode;

  private Integer number_absences;

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
   * @return centerId
   */
  public Integer getCenterId() {

    return this.centerId;
  }

  /**
   * @param centerId new value of {@link #getcenterId}.
   */
  public void setCenterId(Integer centerId) {

    this.centerId = centerId;
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
   * @return number_absences
   */
  public Integer getNumber_absences() {

    return this.number_absences;
  }

  /**
   * @param number_absences new value of {@link #getnumber_absences}.
   */
  public void setNumber_absences(Integer number_absences) {

    this.number_absences = number_absences;
  }

}
