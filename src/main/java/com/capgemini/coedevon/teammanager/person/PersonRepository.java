package com.capgemini.coedevon.teammanager.person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

  PersonEntity findByUsername(String username);

  PersonEntity findByUsernameOrSaga(String username, String saga);

  PersonEntity findBySaga(String saga);

  PersonEntity findById(Integer id);

  PersonEntity findIdByUsername(String username);

  PersonEntity findByUsernameAndActiveTrue(String username);

  @Query(value = "select * from person where concat(name, ' ', lastname, ' ', username) LIKE %:name% LIMIT 15", nativeQuery = true)
  public List<PersonEntity> filtrarPersonas(@Param("name") String name);

  @Query(value = "select * from person where id in (select person_id from V_GROUP_MEMBERS_ALL where group_id = :groupId)", nativeQuery = true)
  public List<PersonEntity> findPersonByGroupId(@Param("groupId") Long groupId);

}
