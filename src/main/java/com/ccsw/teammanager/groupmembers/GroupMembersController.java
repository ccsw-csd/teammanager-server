package com.ccsw.teammanager.groupmembers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        LocalDate date = LocalDate.now();
        Integer year = date.getYear();
        Integer month = date.getMonthValue();

        int workingDays;
        int festives;
        int others;
        int vacations;

        List<Detail> details = new ArrayList<>();

        // Formo lista con los ID de los miembros del grupo
        List<Long> membersId = members.stream().map(GroupMembersDto::getPersonId).collect(Collectors.toList());

        // Recoger nombre de los miembros del grupo

        List<PersonEntity> persons = personService.findAllById(membersId);

        // Recoger las ausencias de todos los miembros del grupo

        month = 1;
        List<PersonAbsenceEntity> membersAbsences = personAbsenceService.findAllByPersonIdInAndYearAndMonth(membersId,
                year, month);

        for (GroupMembersDto member : members) {
            Detail detail = new Detail();
            workingDays = 0;
            festives = 0;
            others = 0;
            vacations = 0;

            // Obtener datos del miembro
            Optional<PersonEntity> personOptional = persons.stream()
                    .filter(person -> person.getId().equals(member.getPersonId())).findFirst();

            personOptional.ifPresent(person -> {
                detail.setPerson(person);
                detail.setFullName(person.getName() + " " + person.getLastname());
            });

            // Obtener las ausencias correspondientes al miembro
            List<PersonAbsenceEntity> absences = membersAbsences.stream()
                    .filter(absence -> absence.getPerson().getId().equals(member.getPersonId()))
                    .collect(Collectors.toList());

            detail.setAbsences(absences);

            // TODO: Calcular dias trabajados
            detail.setWorkingDays(workingDays);

            for (PersonAbsenceEntity absence : absences) {

                switch (absence.getType()) {
                case "VAC":
                    vacations++;
                    break;
                case "OTH":
                    others++;
                    break;
                default:
                    festives++;
                    break;

                }

            }

            detail.setWorkingDays(29);
            detail.setFestives(festives);
            detail.setOthers(others);
            detail.setVacations(vacations);
            details.add(detail);

        }

        return details;
    }

}
