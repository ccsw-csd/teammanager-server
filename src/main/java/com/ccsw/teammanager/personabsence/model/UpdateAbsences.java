package com.ccsw.teammanager.personabsence.model;

import java.util.List;

public class UpdateAbsences {

    private List<PersonAbsenceDto> vacations;
    private List<PersonAbsenceDto> vacationsToDelete;

    public List<PersonAbsenceDto> getVacations() {
        return vacations;
    }

    public List<PersonAbsenceDto> getVacationsToDelete() {
        return vacationsToDelete;
    }

    public void setVacations(List<PersonAbsenceDto> vacations) {
        this.vacations = vacations;
    }

    public void setVacationsToDelete(List<PersonAbsenceDto> vacationsToDelete) {
        this.vacationsToDelete = vacationsToDelete;
    }

}
