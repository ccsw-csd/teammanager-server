package com.capgemini.coedevon.teammanager.center;

import java.util.List;

import com.capgemini.coedevon.teammanager.center.model.CenterEntity;

/**
 * @author aolmosca
 *
 */
public interface CenterService {
  List<CenterEntity> getAllCenters();

  CenterEntity getById(Integer id);
}
