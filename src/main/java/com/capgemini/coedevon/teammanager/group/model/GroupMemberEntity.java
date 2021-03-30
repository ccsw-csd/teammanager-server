package com.capgemini.coedevon.teammanager.group.model;

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
@Table(name = "group_members")
public class GroupMemberEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "group_id", nullable = true)
  private Long group_id;

  @Column(name = "person_id", nullable = true)
  private Long member_id;
}
