package com.ccsw.teammanager.person.model;

/**
 * @author aolmosca
 *
 */
public class PersonDto {
    private Long id;

    private String saga;

    private String username;

    private String email;

    private String name;

    private String lastname;

    private Long centerId;

    private String businesscode;

    private Integer active;

    private boolean withPON;

    private String grade;

    private boolean createdByldap;

    private String globalEmployeeId;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getid}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return saga
     */
    public String getSaga() {

        return this.saga;
    }

    /**
     * @param saga new value of {@link #getsaga}.
     */
    public void setSaga(String saga) {

        this.saga = saga;
    }

    /**
     * @return username
     */
    public String getUsername() {

        return this.username;
    }

    /**
     * @param username new value of {@link #getusername}.
     */
    public void setUsername(String username) {

        this.username = username;
    }

    /**
     * @return email
     */
    public String getEmail() {

        return this.email;
    }

    /**
     * @param email new value of {@link #getemail}.
     */
    public void setEmail(String email) {

        this.email = email;
    }

    /**
     * @return name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name new value of {@link #getname}.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return lastname
     */
    public String getLastname() {

        return this.lastname;
    }

    /**
     * @param lastname new value of {@link #getlastname}.
     */
    public void setLastname(String lastname) {

        this.lastname = lastname;
    }

    /**
     * @return center_id
     */
    public Long getCenterId() {

        return this.centerId;
    }

    /**
     * @param center_id new value of {@link #getcenter_id}.
     */
    public void setCenterId(Long centerId) {

        this.centerId = centerId;
    }

    /**
     * @return businesscode
     */
    public String getBusinesscode() {

        return this.businesscode;
    }

    /**
     * @param businesscode new value of {@link #getbusinesscode}.
     */
    public void setBusinesscode(String businesscode) {

        this.businesscode = businesscode;
    }

    /**
     * @return active
     */
    public Integer getActive() {

        return this.active;
    }

    /**
     * @param active new value of {@link #getactive}.
     */
    public void setActive(Integer active) {

        this.active = active;
    }

    public boolean isWithPON() {
        return withPON;
    }

    public void setWithPON(boolean withPON) {
        this.withPON = withPON;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isCreatedByldap() {
        return createdByldap;
    }

    public void setCreatedByldap(boolean createdByldap) {
        this.createdByldap = createdByldap;
    }

    public String getGlobalEmployeeId() {
        return globalEmployeeId;
    }

    public void setGlobalEmployeeId(String globalEmployeeId) {
        this.globalEmployeeId = globalEmployeeId;
    }

    public boolean getWithPON() {
        return withPON;
    }

    @Override
    public String toString() {
        return "PersonDto{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}
