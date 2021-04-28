package com.capgemini.coedevon.teammanager.centerFestive.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "festive")
public class CenterFestiveEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  public long id;

  @Column(name = "center_id")
  public long centerid;

  @Column(name = "year")
  public int year;

  @Column(name = "month")
  public int month;

  @Column(name = "date")
  public Date date;

  /**
   * @return id
   */
  public long getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getid}.
   */
  public void setId(long id) {

    this.id = id;
  }

  /**
   * @return centerid
   */
  public long getCenterid() {

    return this.centerid;
  }

  /**
   * @param centerid new value of {@link #getcenterid}.
   */
  public void setCenterid(long centerid) {

    this.centerid = centerid;
  }

  /**
   * @return year
   */
  public int getYear() {

    return this.year;
  }

  /**
   * @param year new value of {@link #getyear}.
   */
  public void setYear(int year) {

    this.year = year;
  }

  /**
   * @return month
   */
  public int getMonth() {

    return this.month;
  }

  /**
   * @param month new value of {@link #getmonth}.
   */
  public void setMonth(int month) {

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

}
