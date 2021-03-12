package com.capgemini.coedevon.teammanager.person;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

  PersonEntity findByUsername(String username);

  PersonEntity findByUsernameOrSaga(String username, String saga);

  PersonEntity findBySaga(String saga);

}
