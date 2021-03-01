package com.capgemini.coedevon.teammanager.ldap;

import java.util.List;

import com.capgemini.coedevon.teammanager.ldap.model.PersonRawDto;

/**
 * @author pajimene
 *
 */
public interface PersonLdapRepository {

  /**
   * Recupera todas las personas del LDAP Spain
   * @return
   */
  List<PersonRawDto> findAllPersonFromLDAP();

  /**
   * Borra las personas de la tabla temporal
   */
  void deleteAllTemporary();

  /**
   * Guarda el listado de personas la tabla temporal
   * @param list
   */
  void persistAllTemporary(List<PersonRawDto> list);

  /**
   * Mueve las personas de la tabla temporal a la tabla real
   */
  void moveTemporaryToRealPerson();

}
