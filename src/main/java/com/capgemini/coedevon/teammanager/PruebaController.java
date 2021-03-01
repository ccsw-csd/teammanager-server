package com.capgemini.coedevon.teammanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.coedevon.teammanager.absence.AbsenceService;
import com.capgemini.coedevon.teammanager.ldap.LdapService;
import com.capgemini.coedevon.teammanager.ponabsence.PonAbsenceService;
import com.capgemini.coedevon.teammanager.user.UserRepository;

/**
 * @author pajimene
 *
 */
@RequestMapping(value = "/public/prueba")
@RestController
public class PruebaController {

  @Autowired
  PonAbsenceService ponService;

  @Autowired
  LdapService ldapService;

  @Autowired
  AbsenceService absenceService;

  @Autowired
  UserRepository userRepository;

  @RequestMapping(path = "/importDataFromLdap", method = RequestMethod.GET)
  public void importDataFromLdap() {

    this.ldapService.importDataFromLdap();
  }

  @RequestMapping(path = "/importDataFromPon", method = RequestMethod.GET)
  public void importDataFromPon() {

    this.ponService.importDataFromPON();
  }

  @RequestMapping(path = "/absence/{year}/update", method = RequestMethod.GET)
  public void update(@PathVariable("year") Integer year) {

    this.absenceService.regenerateTable(year, null);

  }

  @RequestMapping(path = "/absence/{year}/update_user/{username}", method = RequestMethod.GET)
  public void update(@PathVariable("year") Integer year, @PathVariable("username") String username) {

    this.absenceService.regenerateTable(year, username);

  }

  @RequestMapping(path = "/user/{username}", method = RequestMethod.GET)
  public void update(@PathVariable("username") String username) {

    this.userRepository.getByUsername(username);

  }

}
