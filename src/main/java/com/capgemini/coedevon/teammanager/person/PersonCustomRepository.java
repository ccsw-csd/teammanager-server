package com.capgemini.coedevon.teammanager.person;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface PersonCustomRepository {

  @Query(value = "select * from person where ((name LIKE :prefix%) OR (lastname LIKE :prefix%) OR (username LIKE :prefix%)) LIMIT 15", nativeQuery = true)
  public List<PersonEntity> filtrarPersonas(@Param("prefix") String prefix);
}
