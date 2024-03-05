package com.ccsw.teammanager.personabsence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.config.mapper.BeanMapper;
import com.ccsw.teammanager.personabsence.model.AbsenceEntity;
import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;

@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    AbsenceRepository absenceRepository;

    @Autowired
    private BeanMapper beanMapper;

    @Override
    public void save(List<PersonAbsenceDto> data) {

        List<AbsenceEntity> absences = new ArrayList<>();

        for (PersonAbsenceDto personAbsence : data) {
            AbsenceEntity absence = new AbsenceEntity();

            absence.setSaga(personAbsence.getPerson().getSaga());
            absence.setYear(personAbsence.getYear());
            absence.setMonth(personAbsence.getMonth() + 1);
            absence.setDate(personAbsence.getDate());
            absence.setAbsence_type(personAbsence.getAbsence_type());
            absences.add(absence);
        }

        this.absenceRepository.saveAll(absences);

    }

    @Override
    public void delete(List<PersonAbsenceDto> data) {
        for (PersonAbsenceDto personAbsence : data) {
            Date date = personAbsence.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            date = calendar.getTime();
            this.absenceRepository.deleteBySagaAndDate(personAbsence.getPerson().getSaga(), date);
        }

    }

}
