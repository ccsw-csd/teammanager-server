package com.capgemini.coedevon.teammanager.absence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.coedevon.teammanager.center.model.CenterEntity;

/**
 * @author pajimene
 *
 */
@Entity
@Table(name = "absence")
public class AbsenceEntity {

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "saga")
  private String saga;

  @Column(name = "username")
  private String username;

  @Column(name = "name")
  private String name;

  @Column(name = "lastname")
  private String lastname;

  @ManyToOne
  @JoinColumn(name = "center_id")
  private CenterEntity center;

  @Column(name = "active")
  private Boolean active;

  @Column(name = "year")
  private Integer year;

  @Column(name = "month")
  private Integer month;

  @Column(name = "date")
  private Date date;

  @Column(name = "type")
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
  public CenterEntity getCenter() {

    return this.center;
  }

  /**
   * @param center new value of {@link #getcenter}.
   */
  public void setCenter(CenterEntity center) {

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
