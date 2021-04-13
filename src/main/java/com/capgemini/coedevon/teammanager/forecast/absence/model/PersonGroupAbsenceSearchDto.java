package com.capgemini.coedevon.teammanager.forecast.absence.model;

import java.util.Date;

/**
 * @author aolmosca
 *
 */
public class PersonGroupAbsenceSearchDto {

  private Long groupId;

  private Date init;

  private Date end;

  /**
   * @return groupId
   */
  public Long getGroupId() {

    return this.groupId;
  }

  /**
   * @param groupId new value of {@link #getgroupId}.
   */
  public void setGroupId(Long groupId) {

    this.groupId = groupId;
  }

  /**
   * @return init
   */
  public Date getInit() {

    return this.init;
  }

  /**
   * @param init new value of {@link #getinit}.
   */
  public void setInit(Date init) {

    this.init = init;
  }

  /**
   * @return end
   */
  public Date getEnd() {

    return this.end;
  }

  /**
   * @param end new value of {@link #getend}.
   */
  public void setEnd(Date end) {

    this.end = end;
  }

}
