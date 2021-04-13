package com.capgemini.coedevon.teammanager.person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

  @Query(value = "select p from PersonEntity p where (p.username = :username and p.active = 1)")
  PersonEntity findByUsernameActive(@Param("username") String username);

}
