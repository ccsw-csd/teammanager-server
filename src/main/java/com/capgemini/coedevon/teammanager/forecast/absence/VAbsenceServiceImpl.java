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
import com.capgemini.coedevon.teammanager.forecast.absence.model.VAbsenceDto;
import com.capgemini.coedevon.teammanager.forecast.absence.model.VAbsenceEntity;

/**
 * @author aolmosca
 *
 */
@Service
@Transactional(readOnly = true)
public class VAbsenceServiceImpl implements VAbsenceService {

  @Autowired
  VAbsenceRepository vabsenceRepository;

  @Autowired
  private BeanMapper beanMapper;

  @Override
  public Map<String, List<VAbsenceDto>> getGroupAbsenceByDate(Long groupId, Date init, Date end) {

    HashMap<String, List<VAbsenceDto>> hashAbsence = new HashMap<String, List<VAbsenceDto>>();

    List<VAbsenceDto> listAbsence = this.beanMapper
        .mapList(this.vabsenceRepository.findByGroupIdAndDateBetween(groupId, init, end), VAbsenceDto.class);

    for (VAbsenceDto vabsencedto : listAbsence) {
      // hashAbsence.put(vabsencedto.getPerson().getName() + " " + vabsencedto.getPerson().getLastname(), vabsencedto);
      hashAbsence.computeIfAbsent(vabsencedto.getPerson().getName() + " " + vabsencedto.getPerson().getLastname(),
          k -> new ArrayList<>()).add(vabsencedto);
    }

    return hashAbsence;
  }

  @Override
  public List<VAbsenceEntity> findYearAndUsername(String username, Integer year) {

    return this.vabsenceRepository.findByYearAndPerson_Username(year, username);
  }

}
