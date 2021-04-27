package com.capgemini.coedevon.teammanager.forecast;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.forecast.model.ForecastDto;
import com.capgemini.coedevon.teammanager.person.PersonRepository;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;
import com.capgemini.coedevon.teammanager.personabsence.PersonAbsenceRepository;
import com.capgemini.coedevon.teammanager.personabsence.model.PersonAbsenceEntity;

/**
 * @author aolmosca
 *
 */
@Service
@Transactional(readOnly = true)
public class ForecastServiceImpl implements ForecastService {

  @Autowired
  PersonAbsenceRepository personAbsenceRepository;

  @Autowired
  PersonRepository personRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, List<ForecastDto>> getGroupAbsenceByDate(Long groupId, Date init, Date end) {

    List<PersonEntity> groupMembersList = this.personRepository.findPersonByGroupId(groupId);

    List<Integer> personIds = extractListPersonId(groupMembersList);
    List<PersonAbsenceEntity> absenceList = this.personAbsenceRepository.findByPerson_IdInAndDateBetween(personIds,
        init, end);

    HashMap<String, List<ForecastDto>> hashAbsence = new HashMap<>();

    for (PersonEntity member : groupMembersList) {

      String key = member.getLastname() + ", " + member.getName();

      hashAbsence.put(key, extractAbsencesFromList(member.getId(), absenceList));
    }

    return hashAbsence;
  }

  private List<ForecastDto> extractAbsencesFromList(Integer integer, List<PersonAbsenceEntity> absenceList) {

    List<ForecastDto> listAbsence = new ArrayList<>();
    Map<Date, ForecastDto> mapAbsences = new HashMap<>();
    for (PersonAbsenceEntity absence : absenceList) {

      if (integer.equals(absence.getPerson().getId()) == false)
        continue;

      int weekDay = absence.getDate().getDay();

      if (weekDay == 0 || weekDay == 6)
        continue;

      String absenceType = absence.getType();
      ForecastDto absenceDto = mapAbsences.get(absence.getDate());
      if (absenceDto == null) {
        absenceDto = new ForecastDto();
        absenceDto.setDate(absence.getDate());
        absenceDto.setMonth(absence.getMonth());
        absenceDto.setYear(absence.getYear());
        absenceDto.setType(absenceType);

        listAbsence.add(absenceDto);
        mapAbsences.put(absence.getDate(), absenceDto);
      }

      String absenceDtoType = absenceDto.getType();

      if (absenceType.equals("F")) {
        absenceDto.setType(absenceType);
      } //
      else if (absenceType.equals("P") || absenceType.equals("A")) {
        if (absenceDtoType.equals("P") || absenceDtoType.equals("A")) {
          absenceDto.setType(absenceType);
        }
      }

    }

    return listAbsence;
  }

  /**
   * @param groupId
   */
  private List<Integer> extractListPersonId(List<PersonEntity> groupMembersList) {

    List<Integer> personIds = new ArrayList<>();

    for (PersonEntity groupMember : groupMembersList) {
      personIds.add(groupMember.getId());
    }

    return personIds;
  }
}
