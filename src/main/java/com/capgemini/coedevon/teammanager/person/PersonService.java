package com.capgemini.coedevon.teammanager.person;

import com.capgemini.coedevon.teammanager.person.model.PersonDto;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonService {

  PersonEntity personExists(String username);

  boolean create(PersonDto person);
}
