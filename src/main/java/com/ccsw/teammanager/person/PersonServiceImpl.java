package com.ccsw.teammanager.person;

import java.util.List;

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

    @Override
    public PersonEntity getByUsername(String username) {

        return this.personRepository.findByUsername(username);
    }

    @Override
    public List<PersonEntity> findByTextAndActive(String name) {

        name = name.replaceAll(" ", "%");
        return this.personRepository.findByTextAndActive(name);
    }

}
