package com.capgemini.coedevon.teammanager.person;

import java.util.List;

import com.capgemini.coedevon.teammanager.person.model.PersonDto;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;
import com.capgemini.coedevon.teammanager.person.model.TPersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonService {

  PersonEntity personExists(String username);

  boolean createOrUpdate(PersonDto person);

  void create(PersonDto personDto);

  void update(PersonDto personDto);

  public List<TPersonEntity> notInPerson();

  public List<PersonEntity> personWithoutCenter();

  public List<PersonEntity> personWithSagaOrUserDuplicated();

  /**
   * @param username
   * @return
   */
  PersonEntity getManager(String username);
}
