package com.ccsw.teammanager.person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ccsw.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    PersonEntity findByUsername(String username);

    @Query(value = "select * from person where concat(name, ' ', lastname, ' ', username) LIKE %:name% AND active = TRUE LIMIT 15", nativeQuery = true)
    public List<PersonEntity> findByTextAndActive(String name);

    List<PersonEntity> findAllByIdIn(List<Long> idMembers);

}
