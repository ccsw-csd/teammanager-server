package com.capgemini.coedevon.teammanager.person;

import com.capgemini.coedevon.teammanager.person.model.PersonDto;

/**
 * @author aolmosca
 *
 */
public interface PersonService {

  PersonDto personExists(String username);

  boolean create(PersonDto person);

}
