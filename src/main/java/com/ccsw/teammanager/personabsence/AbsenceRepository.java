package com.ccsw.teammanager.personabsence;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.teammanager.personabsence.model.AbsenceEntity;

/**
 *
 */
public interface AbsenceRepository extends CrudRepository<AbsenceEntity, Integer> {

    void deleteBySagaAndDate(String saga, Date date);

}
