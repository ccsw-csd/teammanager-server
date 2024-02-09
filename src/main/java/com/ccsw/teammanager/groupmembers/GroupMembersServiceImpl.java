package com.ccsw.teammanager.groupmembers;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.groupmembers.model.Detail;
import com.ccsw.teammanager.groupmembers.model.GroupMembersDto;
import com.ccsw.teammanager.groupmembers.model.GroupMembersEntity;
import com.ccsw.teammanager.person.PersonService;
import com.ccsw.teammanager.person.model.PersonDto;
import com.ccsw.teammanager.person.model.PersonEntity;
import com.ccsw.teammanager.personabsence.PersonAbsenceService;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

@Service
@Transactional
public class GroupMembersServiceImpl implements GroupMembersService {

    @Autowired
    private BeanMapper beanMapper;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonAbsenceService personAbsenceService;

    @Autowired
    GroupMembersRepository groupMembersRepository;

    @Override
    public List<GroupMembersEntity> findByGroupId(Long groupId) {
        return groupMembersRepository.findByGroupId(groupId);
    }

    @Override
    public List<Detail> findDetails(Long groupId, LocalDateTime startDate, LocalDateTime endDate) {

        List<GroupMembersDto> members = this.beanMapper.mapList(this.findByGroupId(groupId), GroupMembersDto.class);

        int workingDays = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;

        int festives;
        int others;
        int vacations;

        List<Detail> details = new ArrayList<>();

        // Formo lista con los ID de los miembros del grupo
        List<Long> membersId = members.stream().map(GroupMembersDto::getPersonId).collect(Collectors.toList());

        // Recoger nombre de los miembros del grupo

        List<PersonEntity> persons = personService.findAllById(membersId);

        // Recoger las ausencias de todos los miembros del grupo

        List<PersonAbsenceEntity> membersAbsences = personAbsenceService.findAllByPersonIdInAndDateBetween(membersId,
                Date.valueOf(startDate.toLocalDate()), Date.valueOf(endDate.toLocalDate()));

        for (GroupMembersDto member : members) {
            Detail detail = new Detail();
            festives = 0;
            others = 0;
            vacations = 0;

            // Obtener datos del miembro
            Optional<PersonEntity> personOptional = persons.stream()
                    .filter(person -> person.getId().equals(member.getPersonId())).findFirst();

            personOptional.ifPresent(person -> {
                detail.setPerson(this.beanMapper.map(person, PersonDto.class));
                detail.setFullName(person.getName() + " " + person.getLastname());
            });

            // Obtener las ausencias correspondientes al miembro
            List<PersonAbsenceEntity> absences = membersAbsences.stream()
                    .filter(absence -> absence.getPerson().getId().equals(member.getPersonId()))
                    .collect(Collectors.toList());

            detail.setAbsences(this.beanMapper.mapList(absences, PersonAbsenceDto.class));

            for (PersonAbsenceEntity absence : absences) {

                switch (absence.getAbsence_type()) {
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

            detail.setWorkingDays(workingDays - festives - others - vacations);
            detail.setFestives(festives);
            detail.setOthers(others);
            detail.setVacations(vacations);
            details.add(detail);

        }

        return details;
    }

}
