package com.ccsw.teammanager.personabsence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.personabsence.model.AbsenceEntity;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;

@RequestMapping(value = "/absence")
@RestController
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private BeanMapper beanMapper;

    /**
     * @param data
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public void save(@RequestBody List<PersonAbsenceDto> data) {

        this.absenceService.save(data);
    }

    /**
     * Método para borrar una lista de {@link AbsenceEntity}
     *
     * @param id PK de la ausencia
     */
    @RequestMapping(path = "", method = RequestMethod.DELETE)
    public void delete(@RequestBody List<PersonAbsenceDto> data) throws Exception {

        this.absenceService.delete(data);
    }
}
