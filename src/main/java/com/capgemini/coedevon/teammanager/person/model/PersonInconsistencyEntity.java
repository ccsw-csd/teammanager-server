package com.capgemini.coedevon.teammanager.person.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author aolmosca
 *
 */
@Entity
@Table(name = "v_person_number_absences")
public class PersonInconsistencyEntity {

  @Column(name = "saga", nullable = false)
  private String saga;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "lastname", nullable = false)
  private String lastname;

  @Column(name = "center_id")
  private Integer centerId;

  @Column(name = "businesscode")
  private String businesscode;

  @Column(name = "number_absences", nullable = false)
  private Integer numberAbsences;

}
