package com.ccsw.teammanager.person;

import java.util.List;
import java.util.Optional;

import com.ccsw.teammanager.groupmembers.model.Detail;
import com.ccsw.teammanager.person.model.PersonEntity;

/**
 * @author aolmosca
 *
 */
public interface PersonService {

    PersonEntity getByUsername(String username);

    List<PersonEntity> findByTextAndActive(String name);

    Optional<PersonEntity> findById(Long id);

    List<PersonEntity> findAllById(List<Long> idMembers);

    Detail findUserDetails(String username, String year);
}
