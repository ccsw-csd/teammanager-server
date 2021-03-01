package com.capgemini.coedevon.teammanager.ldap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.ldap.model.PersonRawDto;

/**
 * @author pajimene
 *
 */
@Service
@Transactional(readOnly = true)
public class LdapServiceImpl implements LdapService {

  @Autowired
  private PersonLdapRepository personLdap;

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = false)
  public void importDataFromLdap() {

    List<PersonRawDto> personRaw = this.personLdap.findAllPersonFromLDAP();

    this.personLdap.deleteAllTemporary();
    this.personLdap.persistAllTemporary(personRaw);
    this.personLdap.moveTemporaryToRealPerson();
  }

}
