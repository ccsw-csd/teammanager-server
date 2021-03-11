package com.capgemini.coedevon.teammanager.center;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.coedevon.teammanager.center.model.CenterDto;
import com.capgemini.coedevon.teammanager.center.model.CenterEntity;

/**
 * @author aolmosca
 *
 */
@Service
public class CenterServiceImpl implements CenterService {

  @Autowired
  CenterRepository centerRepository;

  private static final Logger LOG = LoggerFactory.getLogger(CenterServiceImpl.class);

  @Override
  public List<CenterDto> getAllCenters() {

    Iterable<CenterEntity> centersEntities;
    centersEntities = this.centerRepository.findAll();
    List<CenterDto> centerDtoList = new ArrayList<CenterDto>();

    for (CenterEntity entity : centersEntities) {
      CenterDto centerDto = new CenterDto();
      centerDto.setId(entity.getId());
      centerDto.setName(entity.getName());
      centerDtoList.add(centerDto);
    }

    return centerDtoList;
  }

}
