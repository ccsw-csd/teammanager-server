package com.capgemini.coedevon.teammanager.group.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO apastorm This type ...
 *
 */
@Entity
@Table(name = "group_subgroup")
public class GroupSubgroupEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "group_id", nullable = true)
  private List group_id;

  @Column(name = "subgroup_id", nullable = true)
  private List subgroup_id;

}