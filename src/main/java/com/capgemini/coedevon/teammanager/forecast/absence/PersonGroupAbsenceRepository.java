package com.capgemini.coedevon.teammanager.forecast.absence;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.forecast.absence.model.PersonGroupAbsenceEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonGroupAbsenceRepository extends CrudRepository<PersonGroupAbsenceEntity, String> {

  List<PersonGroupAbsenceEntity> findByGroupIdAndDateBetween(Long groupId, Date init, Date end);

}
