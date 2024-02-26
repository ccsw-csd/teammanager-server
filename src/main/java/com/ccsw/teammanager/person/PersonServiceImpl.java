package com.ccsw.teammanager.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.groupmembers.model.Detail;
import com.ccsw.teammanager.person.model.PersonDto;
import com.ccsw.teammanager.person.model.PersonEntity;
import com.ccsw.teammanager.personabsence.PersonAbsenceService;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

/**
 * @author aolmosca
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BeanMapper beanMapper;

    @Autowired
    private PersonAbsenceService personAbsenceService;

    @Override
    public PersonEntity getByUsername(String username) {

        return this.personRepository.findByUsername(username);
    }

    @Override
    public List<PersonEntity> findByTextAndActive(String name) {

        name = name.replaceAll(" ", "%");
        return this.personRepository.findByTextAndActive(name);
    }

    @Override
    public Optional<PersonEntity> findById(Long id) {
        return this.personRepository.findById(id);
    }

    @Override
    public List<PersonEntity> findAllById(List<Long> idMembers) {
        return personRepository.findAllByIdIn(idMembers);
    }

    @Override
    public Detail findUserDetails(String username, String year) {
        Detail detail = new Detail();

        // Recoger datos del usuario
        detail.setPerson(this.beanMapper.map(personRepository.findByUsername(username), PersonDto.class));

        // Recoger ausencias del usuario

        List<PersonAbsenceEntity> userAbsences = personAbsenceService
                .findAllByPersonIdAndYear(detail.getPerson().getId(), Integer.parseInt(year));

        detail.setAbsences(this.beanMapper.mapList(userAbsences, PersonAbsenceDto.class));

        return detail;
    }

}
