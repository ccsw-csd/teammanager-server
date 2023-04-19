package com.ccsw.teammanager.person;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.teammanager.person.model.PersonInconsistencyEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonInconsistencyRepository extends CrudRepository<PersonInconsistencyEntity, Long> {

}
