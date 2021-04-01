package com.capgemini.coedevon.teammanager.forecast.absence;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.forecast.absence.model.VAbsenceEntity;

/**
 * @author aolmosca
 *
 */
public interface VAbsenceRepository extends CrudRepository<VAbsenceEntity, String> {

  List<VAbsenceEntity> findByGroupIdAndDateBetween(Long groupId, Date init, Date end);

  List<VAbsenceEntity> findByYearAndPerson_Username(Integer year, String username);
}
