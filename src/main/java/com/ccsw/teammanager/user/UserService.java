package com.ccsw.teammanager.user;

import com.ccsw.teammanager.user.model.UserEntity;

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
