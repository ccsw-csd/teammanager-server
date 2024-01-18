package com.ccsw.teammanager.personabsence;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.groupmembers.model.GroupMembersDto;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;

@RequestMapping(value = "/v_person_absence")
@RestController
@CrossOrigin(origins = "*")
public class PersonAbsenceController {

    @Autowired
    private PersonAbsenceService personAbsenceService;

    @Autowired
    private BeanMapper beanMapper;

    /**
     * Método para recuperar registros a partir del person_id y de las fechas de
     * inicio y fin
     *
     * @return {@link List} de {@link GroupMembersDto}
     */

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<PersonAbsenceDto> findAbsences(@RequestBody Long person_id, @RequestBody Date startDate,
            @RequestBody Date endDate) {
        return this.beanMapper.mapList(this.personAbsenceService.findAbsences(person_id, startDate, endDate),
                PersonAbsenceDto.class);
    }
}
