package com.capgemini.coedevon.teammanager.center;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.center.model.CenterEntity;

/**
 * @author aolmosca
 *
 */
public interface CenterRepository extends CrudRepository<CenterEntity, Long> {
}
