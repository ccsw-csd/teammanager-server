package com.ccsw.teammanager.groupmembers.model;

import java.util.List;

import com.ccsw.teammanager.person.model.PersonEntity;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

public class Detail {

    private PersonEntity person;

    private Integer workingDays;

    private Integer festives;

    private Integer vacations;

    private Integer others;

    private List<PersonAbsenceEntity> absences;

    private String fullName;

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }

    public Integer getFestives() {
        return festives;
    }

    public void setFestives(Integer festives) {
        this.festives = festives;
    }

    public Integer getVacations() {
        return vacations;
    }

    public void setVacations(Integer vacations) {
        this.vacations = vacations;
    }

    public Integer getOthers() {
        return others;
    }

    public void setOthers(Integer others) {
        this.others = others;
    }

    public List<PersonAbsenceEntity> getAbsences() {
        return absences;
    }

    public void setAbsences(List<PersonAbsenceEntity> absences) {
        this.absences = absences;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
