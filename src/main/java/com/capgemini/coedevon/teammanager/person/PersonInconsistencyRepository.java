package com.capgemini.coedevon.teammanager.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.person.model.PersonInconsistencyEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonInconsistencyRepository extends CrudRepository<PersonInconsistencyEntity, Long> {

  Page<PersonInconsistencyEntity> findByNumberAbsencesLessThanAndCenterId(Integer less, Integer centerId,
      Pageable pageable);
}
