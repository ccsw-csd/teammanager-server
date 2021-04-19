package com.capgemini.coedevon.teammanager.center;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.coedevon.teammanager.center.model.ListadoCentrosFestivosEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface ListadoCentrosFestivosRepository extends CrudRepository<ListadoCentrosFestivosEntity, Long> {

  List<ListadoCentrosFestivosEntity> findAllByOrderByNameAsc();
}
