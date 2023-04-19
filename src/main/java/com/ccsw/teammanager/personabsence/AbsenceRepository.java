package com.ccsw.teammanager.personabsence;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.teammanager.personabsence.model.AbsenceEntity;

/**
 *
 */
public interface AbsenceRepository extends CrudRepository<AbsenceEntity, Integer> {

}
