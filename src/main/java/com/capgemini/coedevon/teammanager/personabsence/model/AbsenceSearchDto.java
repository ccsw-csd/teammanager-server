package com.capgemini.coedevon.teammanager.personabsence.model;

import java.util.Date;
import java.util.List;

/**
 * @author aolmosca
 *
 */
public class AbsenceSearchDto {

  private Integer year;
  
  private List<PersonAbsenceDto> dtos;

  /**
   * @return year
   */
  public Integer getYear() {

    return year;
  }

  /**
   * @param year new value of {@link #getyear}.
   */
  public void setYear(Integer year) {

    this.year = year;
  }
  
  public List<PersonAbsenceDto> getDtos() {

	  return this.dtos;
  }

  public void setDtos(List<PersonAbsenceDto> dtos) {

	  this.dtos = dtos;
  }

}
