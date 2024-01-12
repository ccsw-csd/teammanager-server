package com.ccsw.teammanager.centerFestive;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.teammanager.centerFestive.model.CenterFestiveEntity;

/**
 *
 */
public interface CenterFestiveRepository extends CrudRepository<CenterFestiveEntity, Long> {

    List<CenterFestiveEntity> findByCenterId(Long centerId);
}
