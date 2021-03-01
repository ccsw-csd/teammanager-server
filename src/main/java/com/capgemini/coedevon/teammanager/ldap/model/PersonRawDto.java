package com.capgemini.coedevon.teammanager.ldap.model;

import java.io.Serializable;

/**
 * @author pajimene
 *
 */
public class PersonRawDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String username;

  private String email;

  private String saga;

  private String name;

  private String lastname;

  private String center;

  private String grade;

  private String businesscode;

  private String pucode;

  private String startdate;

  private String jobRole;

  /**
   * {@inheritDoc}
   */
  public String getUsername() {

    return this.username;
  }

  /**
   * {@inheritDoc}
   */

  public void setUsername(String username) {

    this.username = username;
  }

  /**
   * {@inheritDoc}
   */

  public String getEmail() {

    return this.email;
  }

  /**
   * {@inheritDoc}
   */

  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * {@inheritDoc}
   */

  public String getSaga() {

    return this.saga;
  }

  /**
   * {@inheritDoc}
   */

  public void setSaga(String saga) {

    this.saga = saga;
  }

  /**
   * {@inheritDoc}
   */

  public String getName() {

    return this.name;
  }

  /**
   * {@inheritDoc}
   */

  public void setName(String name) {

    this.name = name;
  }

  /**
   * {@inheritDoc}
   */

  public String getLastname() {

    return this.lastname;
  }

  /**
   * {@inheritDoc}
   */

  public void setLastname(String lastname) {

    this.lastname = lastname;
  }

  /**
   * {@inheritDoc}
   */

  public String getCenter() {

    return this.center;
  }

  /**
   * {@inheritDoc}
   */

  public void setCenter(String center) {

    this.center = center;
  }

  /**
   * {@inheritDoc}
   */

  public String getGrade() {

    return this.grade;
  }

  /**
   * {@inheritDoc}
   */

  public void setGrade(String grade) {

    this.grade = grade;
  }

  /**
   * {@inheritDoc}
   */

  public String getBusinesscode() {

    return this.businesscode;
  }

  /**
   * {@inheritDoc}
   */

  public void setBusinesscode(String businesscode) {

    this.businesscode = businesscode;
  }

  /**
   * {@inheritDoc}
   */

  public String getPucode() {

    return this.pucode;
  }

  /**
   * {@inheritDoc}
   */

  public void setPucode(String pucode) {

    this.pucode = pucode;
  }

  /**
   * {@inheritDoc}
   */

  public String getStartdate() {

    return this.startdate;
  }

  /**
   * {@inheritDoc}
   */

  public void setStartdate(String startdate) {

    this.startdate = startdate;
  }

  /**
   * {@inheritDoc}
   */

  public String getJobRole() {

    return this.jobRole;
  }

  /**
   * {@inheritDoc}
   */

  public void setJobRole(String jobRole) {

    this.jobRole = jobRole;
  }

  /**
   * {@inheritDoc}
   */

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 13; //super.hashCode();
    result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((this.saga == null) ? 0 : this.saga.hashCode());
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.lastname == null) ? 0 : this.lastname.hashCode());
    result = prime * result + ((this.center == null) ? 0 : this.center.hashCode());
    result = prime * result + ((this.grade == null) ? 0 : this.grade.hashCode());
    result = prime * result + ((this.businesscode == null) ? 0 : this.businesscode.hashCode());
    result = prime * result + ((this.pucode == null) ? 0 : this.pucode.hashCode());
    result = prime * result + ((this.startdate == null) ? 0 : this.startdate.hashCode());
    result = prime * result + ((this.jobRole == null) ? 0 : this.jobRole.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
   */

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    PersonRawDto other = (PersonRawDto) obj;
    if (this.username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!this.username.equals(other.username)) {
      return false;
    }
    if (this.email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!this.email.equals(other.email)) {
      return false;
    }
    if (this.saga == null) {
      if (other.saga != null) {
        return false;
      }
    } else if (!this.saga.equals(other.saga)) {
      return false;
    }
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.lastname == null) {
      if (other.lastname != null) {
        return false;
      }
    } else if (!this.lastname.equals(other.lastname)) {
      return false;
    }
    if (this.center == null) {
      if (other.center != null) {
        return false;
      }
    } else if (!this.center.equals(other.center)) {
      return false;
    }
    if (this.grade == null) {
      if (other.grade != null) {
        return false;
      }
    } else if (!this.grade.equals(other.grade)) {
      return false;
    }
    if (this.businesscode == null) {
      if (other.businesscode != null) {
        return false;
      }
    } else if (!this.businesscode.equals(other.businesscode)) {
      return false;
    }
    if (this.pucode == null) {
      if (other.pucode != null) {
        return false;
      }
    } else if (!this.pucode.equals(other.pucode)) {
      return false;
    }
    if (this.startdate == null) {
      if (other.startdate != null) {
        return false;
      }
    } else if (!this.startdate.equals(other.startdate)) {
      return false;
    }
    if (this.jobRole == null) {
      if (other.jobRole != null) {
        return false;
      }
    } else if (!this.jobRole.equals(other.jobRole)) {
      return false;
    }
    return true;
  }

}
