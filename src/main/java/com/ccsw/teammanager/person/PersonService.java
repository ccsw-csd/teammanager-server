package com.ccsw.teammanager.person;

import java.util.List;

import com.ccsw.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonService {

    PersonEntity getByUsername(String username);

    List<PersonEntity> findByTextAndActive(String name);
}
