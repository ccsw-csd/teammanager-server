package com.capgemini.coedevon.teammanager.center;

import java.util.List;

import com.capgemini.coedevon.teammanager.center.model.CenterDto;

/**
 * @author aolmosca
 *
 */
public interface CenterService {
  List<CenterDto> getAllCenters();
}
