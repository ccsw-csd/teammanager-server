package com.ccsw.teammanager.personabsence;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.person.model.PersonEntity;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

@Service
@Transactional
public class PersonAbsenceServiceImpl implements PersonAbsenceService {

    @Autowired
    PersonAbsenceRepository personAbsenceRepository;

    @Override
    public List<PersonAbsenceEntity> findAbsences(Long personId, Date startDate, Date endDate) {
        PersonEntity person = new PersonEntity();
        person.setId(personId);
        return personAbsenceRepository.findByPersonAndDateBetween(person, startDate, endDate);
    }

    @Override
    public List<PersonAbsenceEntity> findAbsencesByIdAndDate(Long person_id, Integer year, Integer month) {
        return personAbsenceRepository.findByPersonIdAndYearAndMonth(person_id, year, month);
    }

    @Override
    public List<PersonAbsenceEntity> findAllByPersonIdInAndYearAndMonth(List<Long> membersId, Integer year,
            Integer month) {

        return personAbsenceRepository.findAllByPersonIdInAndYearAndMonth(membersId, year, month);
    }

    @Override
    public List<PersonAbsenceEntity> findAllByPersonIdInAndDateBetween(List<Long> membersId, Date startDate,
            Date endDate) {
        return personAbsenceRepository.findAllByPersonIdInAndDateBetween(membersId, startDate, endDate);
    }

}
