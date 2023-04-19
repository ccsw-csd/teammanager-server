package com.ccsw.teammanager.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Override
    public PersonEntity getByUsername(String username) {

        return this.personRepository.findByUsername(username);
    }
}
