package com.capgemini.coedevon.teammanager.ldap;

/**
 * @author pajimene
 *
 */
public interface LdapService {

  /**
   * Realiza una carga del LDAP a la tabla temporal
   * @return
   */
  void importDataFromLdap();

}
