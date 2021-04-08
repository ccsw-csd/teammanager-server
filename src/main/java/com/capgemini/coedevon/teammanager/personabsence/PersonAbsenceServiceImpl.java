package com.capgemini.coedevon.teammanager.personabsence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.config.mapper.BeanMapper;
import com.capgemini.coedevon.teammanager.person.PersonRepository;
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
}
