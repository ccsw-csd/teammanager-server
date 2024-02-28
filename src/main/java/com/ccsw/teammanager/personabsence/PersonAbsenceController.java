package com.ccsw.teammanager.personabsence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

@RequestMapping(value = "/person_absence")
@RestController
public class PersonAbsenceController {

    @Autowired
    private PersonAbsenceService personAbsenceService;

    @Autowired
    private BeanMapper beanMapper;

    /**
     * @param data
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public List<PersonAbsenceDto> save(@RequestBody List<PersonAbsenceDto> data) {

        return this.beanMapper.mapList(this.personAbsenceService.save(data), PersonAbsenceDto.class);
    }

    /**
     * Método para borrar un {@link PersonAbsenceEntity}
     *
     * @param id PK de la ausencia
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("idVacation") String id) throws Exception {

        this.personAbsenceService.delete(id);
    }
}
