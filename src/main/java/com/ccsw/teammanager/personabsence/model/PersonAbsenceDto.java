package com.ccsw.teammanager.personabsence.model;

import java.util.Date;

import com.ccsw.teammanager.person.model.PersonEntity;

public class PersonAbsenceDto {
    private String id;

    private PersonEntity person;

    private Integer year;

    private Integer month;

    private Date date;

    private String type;

    private String absence_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbsence_type() {
        return absence_type;
    }

    public void setAbsence_type(String absence_type) {
        this.absence_type = absence_type;
    }

}
