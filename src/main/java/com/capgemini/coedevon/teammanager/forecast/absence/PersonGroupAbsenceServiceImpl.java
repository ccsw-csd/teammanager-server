package com.capgemini.coedevon.teammanager.forecast.absence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.forecast.absence.model.PersonGroupAbsenceDto;
import com.capgemini.coedevon.teammanager.person.PersonRepository;

/**
 * @author aolmosca
 *
 */
@Service
@Transactional(readOnly = true)
public class PersonGroupAbsenceServiceImpl implements PersonGroupAbsenceService {

  @Autowired
  PersonGroupAbsenceRepository vabsenceRepository;

  @Autowired
  PersonRepository personRepository;

  @Autowired
  private BeanMapper beanMapper;

  @Override
  public Map<String, List<PersonGroupAbsenceDto>> getGroupAbsenceByDate(Long groupId, Date init, Date end) {

    HashMap<String, List<PersonGroupAbsenceDto>> hashAbsence = new HashMap<>();

    List<PersonGroupAbsenceDto> listAbsence = this.beanMapper
        .mapList(this.vabsenceRepository.findByGroupIdAndDateBetween(groupId, init, end), PersonGroupAbsenceDto.class);

    for (PersonGroupAbsenceDto vabsencedto : listAbsence) {
      hashAbsence.computeIfAbsent(vabsencedto.getPerson().getName() + " " + vabsencedto.getPerson().getLastname(),
          k -> new ArrayList<>()).add(vabsencedto);
    }

    return hashAbsence;
  }
}
