package com.ccsw.teammanager.centerWithFestives.model;

public class CenterWithFestivesDto {

    private Integer id;

    private String name;

    private Integer festiveActualYear;

    private Integer festiveNextYear;

    /**
     * @return id
     */
    public Integer getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Integer id) {

        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name new value of {@link #getName}.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return festiveActualYear
     */
    public Integer getFestiveActualYear() {
        return festiveActualYear;
    }

    /**
     * @param id new value of {@link #getFestiveActualYear}.
     */
    public void setFestiveActualYear(Integer festiveActualYear) {
        this.festiveActualYear = festiveActualYear;
    }

    /**
     * @return festiveNextYear
     */
    public Integer getFestiveNextYear() {
        return festiveNextYear;
    }

    /**
     * @param id new value of {@link #getFestiveNextYear}.
     */
    public void setFestiveNextYear(Integer festiveNextYear) {
        this.festiveNextYear = festiveNextYear;
    }
}
