package com.ccsw.teammanager.groupmembers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.groupmembers.model.Detail;
import com.ccsw.teammanager.groupmembers.model.GroupMembersDto;
import com.ccsw.teammanager.person.PersonService;
import com.ccsw.teammanager.person.model.PersonEntity;
import com.ccsw.teammanager.personabsence.PersonAbsenceService;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

@RequestMapping(value = "/v_group_members_all")
@RestController
@CrossOrigin(origins = "*")
public class GroupMembersController {

    @Autowired
    private GroupMembersService groupMembersService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonAbsenceService personAbsenceService;

    @Autowired
    private BeanMapper beanMapper;

    /**
     * Método para recuperar registros a partir del group_id
     *
     * @return {@link List} de {@link GroupMembersDto}
     */
    /*
     * @RequestMapping(path = "", method = RequestMethod.GET) public
     * List<GroupMembersDto> findByGroupId(@RequestParam(name = "group_id", required
     * = true) Long group_id) { return
     * this.beanMapper.mapList(this.groupMembersService.findByGroupId(group_id),
     * GroupMembersDto.class); }
     * 
     */

    /**
     * Método para recuperar registros a partir del group_id
     *
     * @return {@link List} de {@link GroupMembersDto}
     */

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Detail> findDetailsMembers(@RequestParam(name = "group_id", required = true) Long group_id) {

        List<GroupMembersDto> members = this.beanMapper.mapList(this.groupMembersService.findByGroupId(group_id),
                GroupMembersDto.class);

        List<Detail> details = new ArrayList<>();

        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();

        int workingDays = 0;
        int festives = 0;
        int others = 0;
        int vacations = 0;
        for (GroupMembersDto member : members) {
            // 1º Get Person Data para recoger el nombre y asignarlo al detail
            // 2º Get Ausencias de cada persona y asignarlo al detail
            // 3º Devolver lista details
            Detail detail = new Detail();

            System.out.println("ID: " + member.getPersonId());
            Optional<PersonEntity> person = personService.findById(member.getPersonId());
            person.ifPresent(personPresent -> {
                detail.setPerson(personPresent);
                detail.setFullName(personPresent.getName() + " " + personPresent.getLastname());
            });

            System.out.println(detail.getFullName());
            List<PersonAbsenceEntity> memberAbsences = personAbsenceService
                    .findAbsencesByIdAndDate(member.getPersonId(), year, month);

            detail.setAbsences(memberAbsences);

            // for(PersonAbsenceEntity absence: memberAbsences) {
            // TODO: Realizar comprobacion del tipo de festivo

            detail.setWorkingDays(workingDays);
            detail.setFestives(festives);
            detail.setOthers(others);
            detail.setVacations(vacations);

            // }

            details.add(detail);

        }

        return details;
    }

}
