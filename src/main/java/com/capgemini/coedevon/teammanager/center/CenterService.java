package com.capgemini.coedevon.teammanager.center;

import java.util.List;

import com.capgemini.coedevon.teammanager.center.model.CenterEntity;
import com.capgemini.coedevon.teammanager.center.model.ListadoCentrosFestivosEntity;

/**
 * @author aolmosca
 *
 */
public interface CenterService {
  List<CenterEntity> getAllCenters();

  CenterEntity getById(Integer id);

  /**
   * @return
   */
  List<ListadoCentrosFestivosEntity> listadoCentrosFestivos();
}
