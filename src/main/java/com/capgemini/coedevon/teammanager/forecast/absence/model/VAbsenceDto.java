package com.capgemini.coedevon.teammanager.forecast.absence.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.capgemini.coedevon.teammanager.grouplist.model.GroupListEntity;
import com.capgemini.coedevon.teammanager.person.model.PersonDto;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author aolmosca
 *
 */
public class VAbsenceDto {

  private String id;

  private GroupListEntity group;

  private PersonDto person;

  private Integer year;

  private Integer month;

  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+1")
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
   * @return group
   */
  public GroupListEntity getGroup() {

    return this.group;
  }

  /**
   * @param group new value of {@link #getgroup}.
   */
  public void setGroup(GroupListEntity group) {

    this.group = group;
  }

  /**
   * @return person
   */
  public PersonDto getPerson() {

    return this.person;
  }

  /**
   * @param person new value of {@link #getperson}.
   */
  public void setPerson(PersonDto person) {

    this.person = person;
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
