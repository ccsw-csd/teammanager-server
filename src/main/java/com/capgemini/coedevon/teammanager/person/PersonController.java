package com.capgemini.coedevon.teammanager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.person.model.PersonDto;

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

  @RequestMapping(path = "/personExists/{username}", method = RequestMethod.GET)
  public PersonDto get(@PathVariable("username") String username) {

    return this.personService.personExists(username);

  }

  @RequestMapping(path = "/create/", method = RequestMethod.POST)
  public boolean get(@RequestBody PersonDto dto) {

    return this.personService.create(dto);

  }
}
