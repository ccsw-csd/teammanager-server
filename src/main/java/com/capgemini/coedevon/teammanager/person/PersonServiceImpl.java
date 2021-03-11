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
  public PersonDto personExists(String username) {

    PersonEntity temp = new PersonEntity();
    PersonDto dto = new PersonDto();

    temp = this.personRepository.findByUsername(username);

    if (temp != null)
      BeanUtils.copyProperties(temp, dto);
    return dto;
  }

  @Override
  public boolean create(PersonDto person) {

    if (this.personRepository.findByUsernameOrSaga(person.getUsername(), person.getSaga()) == null) {
      PersonEntity temp = new PersonEntity();
      BeanUtils.copyProperties(person, temp);
      temp.setActive(1);
      this.personRepository.save(temp);
      return true;
    } else {
      if (this.personRepository.findBySaga(person.getSaga()) == null)
        return true;
      else
        return false;
    }
  }
}
