package com.capgemini.coedevon.teammanager.personabsence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.person.PersonRepository;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;
import com.capgemini.coedevon.teammanager.personabsence.model.AbsenceEntity;
import com.capgemini.coedevon.teammanager.personabsence.model.PersonAbsenceDto;

/**
 * @author aolmosca
 *
 */
@Service
@Transactional(readOnly = true)
public class PersonAbsenceServiceImpl implements PersonAbsenceService {

  @Autowired
  PersonAbsenceRepository vabsenceRepository;

  @Autowired
  PersonRepository personRepository;

  @Autowired
  AbsenceRepository absenceRepository;

  @Autowired
  private BeanMapper beanMapper;

  @Override
  public Map<Integer, List<PersonAbsenceDto>> findYearAndUsername(String username, Integer year) {

    HashMap<Integer, List<PersonAbsenceDto>> hashAbsence = new HashMap<>();

    List<PersonAbsenceDto> listAbsence = this.beanMapper
        .mapList(this.vabsenceRepository.findByYearAndPersonUsername(year, username), PersonAbsenceDto.class);

    for (PersonAbsenceDto vabsencedto : listAbsence) {
      hashAbsence.computeIfAbsent(vabsencedto.getMonth(), k -> new ArrayList<>()).add(vabsencedto);
    }

    return hashAbsence;
  }

  @Transactional(readOnly = false)
  @Override
  public void save(List<Date> dates, List<PersonAbsenceDto> absences, String username) {

    PersonEntity personEntity = this.personRepository.findByUsername(username);
    for (int i = 0; i < dates.size(); i++) {
      AbsenceEntity newAbsenceEntity = new AbsenceEntity();
      Calendar calendar = dateToCalendar(dates.get(i));

      newAbsenceEntity.setDate(dates.get(i));
      newAbsenceEntity.setSaga(personEntity.getSaga());
      newAbsenceEntity.setMonth(calendar.get(Calendar.MONTH) + 1);
      newAbsenceEntity.setYear(calendar.get(Calendar.YEAR));
      this.absenceRepository.save(newAbsenceEntity);
    }

    for (int j = 0; j < absences.size(); j++) {
      AbsenceEntity absenceEntity = this.absenceRepository.findByDateAndSaga(absences.get(j).getDate(),
          absences.get(j).getPerson().getSaga());
      this.absenceRepository.delete(absenceEntity);
    }

  }

  private Calendar dateToCalendar(Date date) {

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
  }
}
