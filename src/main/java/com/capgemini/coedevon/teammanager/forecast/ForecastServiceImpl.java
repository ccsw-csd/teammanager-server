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
import com.capgemini.coedevon.teammanager.forecast.model.VGroupMembersAllEntity;
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
  VGroupMembersAllRepository groupMembersAllRepository;

  @Autowired
  PersonAbsenceRepository personAbsenceRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, List<ForecastDto>> getGroupAbsenceByDate(Long groupId, Date init, Date end) {

    List<VGroupMembersAllEntity> groupMembersList = this.groupMembersAllRepository
        .findByGroup_IdOrderByPersonUsername(groupId);

    List<Long> personIds = extractListPersonId(groupMembersList);

    List<PersonAbsenceEntity> absenceList = this.personAbsenceRepository.findByPerson_IdInAndDateBetween(personIds,
        init, end);

    HashMap<String, List<ForecastDto>> hashAbsence = new HashMap<>();

    for (VGroupMembersAllEntity member : groupMembersList) {

      String key = member.getPerson().getName() + " " + member.getPerson().getLastname();

      hashAbsence.put(key, extractAbsencesFromList(member.getPerson().getId(), absenceList));
    }

    return hashAbsence;
  }

  private List<ForecastDto> extractAbsencesFromList(Long personId, List<PersonAbsenceEntity> absenceList) {

    List<ForecastDto> listAbsence = new ArrayList<>();
    Map<Date, ForecastDto> mapAbsences = new HashMap<>();
    for (PersonAbsenceEntity absence : absenceList) {

      if (personId.equals(absence.getPerson().getId()) == false)
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
  private List<Long> extractListPersonId(List<VGroupMembersAllEntity> groupMembersList) {

    List<Long> personIds = new ArrayList<>();

    for (VGroupMembersAllEntity groupMember : groupMembersList) {
      personIds.add(groupMember.getPerson().getId());
    }

    return personIds;
  }
}
