package com.ccsw.teammanager.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.groupmembers.model.Detail;
import com.ccsw.teammanager.person.model.PersonDto;

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

    /**
     * Método para recuperar registros a partir del username
     *
     * @return
     */

    @RequestMapping(path = "", method = RequestMethod.GET)
    public Detail findUserDetails(@RequestParam(name = "username", required = true) String username,
            @RequestParam(name = "year", required = true) String year) {

        return this.personService.findUserDetails(username, year);

    }

}
