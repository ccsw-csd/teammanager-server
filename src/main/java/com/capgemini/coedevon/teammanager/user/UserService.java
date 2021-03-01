package com.capgemini.coedevon.teammanager.user;

import com.capgemini.coedevon.teammanager.user.model.UserEntity;

/**
 * @author pajimene
 *
 */
public interface UserService {

  /**
   * Recupera un usuario con su username
   * @param username
   * @return
   * @throws Exception
   */
  UserEntity getByUsername(String username);
}
