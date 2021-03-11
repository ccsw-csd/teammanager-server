package com.capgemini.coedevon.teammanager.person;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

  PersonEntity findByUsername(String Username);

  PersonEntity findByUsernameOrSaga(String Username, String Saga);

  PersonEntity findBySaga(String Saga);

}
