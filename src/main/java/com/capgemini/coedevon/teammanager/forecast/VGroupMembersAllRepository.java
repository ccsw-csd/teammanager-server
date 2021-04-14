package com.capgemini.coedevon.teammanager.forecast;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.forecast.model.VGroupMembersAllEntity;

/**
 * @author pajimene
 *
 */
public interface VGroupMembersAllRepository extends CrudRepository<VGroupMembersAllEntity, String> {

  /**
   * Recupera un listado de personas de un grupo
   * @param groupId
   * @return
   */
  List<VGroupMembersAllEntity> findByGroup_IdOrderByPersonUsername(Long groupId);

}
