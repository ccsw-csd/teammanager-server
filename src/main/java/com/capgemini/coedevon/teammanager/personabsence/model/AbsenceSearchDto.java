package com.capgemini.coedevon.teammanager.personabsence.model;

import java.util.Date;
import java.util.List;

/**
 * @author aolmosca
 *
 */
public class AbsenceSearchDto {
  List<Date> dates;

  List<PersonAbsenceDto> absences;

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

  /**
   * @return absences
   */
  public List<PersonAbsenceDto> getAbsences() {

    return this.absences;
  }

  /**
   * @param absences new value of {@link #getabsences}.
   */
  public void setAbsences(List<PersonAbsenceDto> absences) {

    this.absences = absences;
  }

}
