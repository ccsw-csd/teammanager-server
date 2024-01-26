package com.ccsw.teammanager.person;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.person.model.PersonDto;
import com.ccsw.teammanager.person.model.PersonEntity;

@RequestMapping(value = "/person")
@RestController
public class PersonController {

    @Autowired
    private BeanMapper beanMapper;

    @Autowired
    private PersonService personService;

    /**
     * @param prefix
     * @return
     */
    @RequestMapping(path = "/find/{name}", method = RequestMethod.GET)
    public List<PersonDto> findByTextAndActive(@PathVariable String name) {

        return this.beanMapper.mapList(this.personService.findByTextAndActive(name), PersonDto.class);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public PersonDto getById(@RequestParam(name = "id", required = true) Long id) {
        Optional<PersonEntity> optionalPersonEntity = this.personService.findById(id);

        PersonEntity personEntity = optionalPersonEntity
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la persona con el ID proporcionado"));

        return this.beanMapper.map(personEntity, PersonDto.class);

    }

}
