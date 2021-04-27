package com.capgemini.coedevon.teammanager.centerFestive.model;

import java.sql.Date;
import java.util.List;

/**
 * TODO apastorm This type ...
 *
 */
public class CenterFestiveSaveDto {

  private int year;

  private List<Date> dates;

  private int centerid;

  /**
   * @return centerid
   */
  public int getCenterid() {

    return this.centerid;
  }

  /**
   * @param centerid new value of {@link #getcenterid}.
   */
  public void setCenterid(int centerid) {

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
   * @return dates
   */
  public List<Date> getDates() {

    return this.dates;
  }

  /**
   * @param dates new value of {@link #getdates}.
   */
  public void setDates(List<Date> dates) {

    this.dates = dates;
  }

}
