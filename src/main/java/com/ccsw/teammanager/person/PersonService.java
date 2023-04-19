package com.ccsw.teammanager.person;

import com.ccsw.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonService {

    PersonEntity getByUsername(String username);
}
