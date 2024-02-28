package com.ccsw.teammanager.personabsence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceEntity;

@Service
@Transactional
public class PersonAbsenceServiceImpl implements PersonAbsenceService {

    @Autowired
    PersonAbsenceRepository personAbsenceRepository;

    @Autowired
    private BeanMapper beanMapper;

    @Override
    public List<PersonAbsenceEntity> findAllByPersonIdInAndDateBetween(List<Long> membersId, Date startDate,
            Date endDate) {
        return personAbsenceRepository.findAllByPersonIdInAndDateBetween(membersId, startDate, endDate);
    }

    @Override
    public List<PersonAbsenceEntity> findAllByPersonIdAndYear(Long personId, int year) {
        return personAbsenceRepository.findAllByPersonIdAndYear(personId, year);
    }

    @Override
    public List<PersonAbsenceEntity> save(List<PersonAbsenceDto> data) {
        String month;
        String day;
        List<PersonAbsenceEntity> absences = new ArrayList<>();

        for (PersonAbsenceDto personAbsence : data) {
            PersonAbsenceEntity absence = new PersonAbsenceEntity();
            if (personAbsence.getMonth() < 10) {
                month = "0" + personAbsence.getMonth();
            } else {
                month = personAbsence.getMonth().toString();
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(personAbsence.getDate());
            if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
                day = "0" + calendar.get(Calendar.DAY_OF_MONTH);
            } else {
                day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            }

            String id = personAbsence.getYear() + "-" + month + "-" + day + personAbsence.getId();
            absence.setId(id);
            absence.setPerson(personAbsence.getPerson());
            absence.setYear(personAbsence.getYear());
            absence.setMonth(personAbsence.getMonth());
            absence.setDate(personAbsence.getDate());
            absence.setType(personAbsence.getType());
            absence.setAbsence_type(personAbsence.getAbsence_type());
            absences.add(absence);
        }

        // TODO: Devolver lista

        return null;
    }

    @Override
    public void delete(String id) throws Exception {

    }

}
