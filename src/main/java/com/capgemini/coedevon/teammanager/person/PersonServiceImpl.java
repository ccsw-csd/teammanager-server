package com.capgemini.coedevon.teammanager.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.coedevon.teammanager.person.model.PersonDto;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  PersonRepository personRepository;

  private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

  @Override
  public PersonEntity personExists(String username) {

    return this.personRepository.findByUsername(username);
  }

  @Override
  public boolean create(PersonDto personDto) {

    if (personNotExists(personDto.getUsername(), personDto.getSaga())) {
      PersonEntity personEntity = new PersonEntity();
      BeanUtils.copyProperties(personDto, personEntity);
      personEntity.setActive(true);
      this.personRepository.save(personEntity);
      return true;
    } else {
      if (sagaNotExists(personDto.getSaga()))
        return true;
      else
        return false;
    }
  }

  private boolean personNotExists(String username, String saga) {

    if (this.personRepository.findByUsernameOrSaga(username, saga) == null)
      return true;
    else
      return false;
  }

  private boolean sagaNotExists(String saga) {

    if (this.personRepository.findBySaga(saga) == null)
      return true;
    else
      return false;
  }
}
