package com.capgemini.coedevon.teammanager.person;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonRepository extends CrudRepository<PersonEntity, Long>, PersonCustomRepository {

  PersonEntity findByUsername(String username);

  PersonEntity findByUsernameOrSaga(String username, String saga);

  PersonEntity findBySaga(String saga);

  PersonEntity findById(Integer id);

  PersonEntity findIdByUsername(String username);

  PersonEntity findByUsernameAndActiveTrue(String username);

}
