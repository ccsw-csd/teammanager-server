package com.capgemini.coedevon.teammanager.person;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.person.model.PersonDto;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
@RequestMapping(value = "/person")
@RestController
public class PersonController {

  @Autowired
  PersonService personService;

  @Autowired
  private BeanMapper beanMapper;

  @RequestMapping(path = "/{username}", method = RequestMethod.GET)
  public PersonDto get(@PathVariable("username") String username) {

    PersonDto person = new PersonDto();
    PersonEntity personEntity = this.personService.personExists(username);

    if (personEntity != null)
      BeanUtils.copyProperties(personEntity, person);

    return person;
  }

  @RequestMapping(path = "/", method = RequestMethod.PUT)
  public boolean create(@RequestBody PersonDto dto) {

    return this.personService.create(dto);

  }
}
