package com.ccsw.teammanager.personabsence;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

@Service
@Transactional
public class PersonAbsenceServiceImpl implements PersonAbsenceService {

    @Autowired
    PersonAbsenceRepository personAbsenceRepository;

    @Override
    public List<PersonAbsenceEntity> findAllByPersonIdInAndDateBetween(List<Long> membersId, Date startDate,
            Date endDate) {
        return personAbsenceRepository.findAllByPersonIdInAndDateBetween(membersId, startDate, endDate);
    }

    @Override
    public List<PersonAbsenceEntity> findAllByPersonIdAndYear(Long personId, int year) {
        return personAbsenceRepository.findAllByPersonIdAndYear(personId, year);
    }

}
