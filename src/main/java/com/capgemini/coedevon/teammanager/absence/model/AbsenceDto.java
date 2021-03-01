package com.capgemini.coedevon.teammanager.absence.model;

import java.util.Date;

import com.capgemini.coedevon.teammanager.center.model.CenterDto;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author pajimene
 *
 */
public class AbsenceDto {

  private String id;

  private String saga;

  private String username;

  private String name;

  private String lastname;

  private CenterDto center;

  private Boolean active;

  private Integer year;

  private Integer month;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date date;

  private String type;

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
   * @return center
   */
  public CenterDto getCenter() {

    return this.center;
  }

  /**
   * @param center new value of {@link #getcenter}.
   */
  public void setCenter(CenterDto center) {

    this.center = center;
  }

  /**
   * @return active
   */
  public Boolean getActive() {

    return this.active;
  }

  /**
   * @param active new value of {@link #getactive}.
   */
  public void setActive(Boolean active) {

    this.active = active;
  }

  /**
   * @return year
   */
  public Integer getYear() {

    return this.year;
  }

  /**
   * @param year new value of {@link #getyear}.
   */
  public void setYear(Integer year) {

    this.year = year;
  }

  /**
   * @return month
   */
  public Integer getMonth() {

    return this.month;
  }

  /**
   * @param month new value of {@link #getmonth}.
   */
  public void setMonth(Integer month) {

    this.month = month;
  }

  /**
   * @return date
   */
  public Date getDate() {

    return this.date;
  }

  /**
   * @param date new value of {@link #getdate}.
   */
  public void setDate(Date date) {

    this.date = date;
  }

  /**
   * @return type
   */
  public String getType() {

    return this.type;
  }

  /**
   * @param type new value of {@link #gettype}.
   */
  public void setType(String type) {

    this.type = type;
  }

}
