package com.capgemini.coedevon.teammanager.releasenote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.config.security.UserUtils;
import com.capgemini.coedevon.teammanager.releasenote.model.ReleaseNoteEntity;
import com.capgemini.coedevon.teammanager.releasenote.model.ReleaseUserEntity;

@Service
@Transactional
public class ReleaseNoteServiceImpl implements ReleaseNoteService {

  @Autowired
  ReleaseNoteRepository releaseNoteRepository;

  @Autowired
  ReleaseUserRepository releaseUserRepository;

  @Override
  @Transactional(readOnly = false)
  public List<ReleaseNoteEntity> findNewReleases() {

    String username = UserUtils.getUserDetails().getUsername();

    ReleaseUserEntity releaseUser = releaseUserRepository.getByUsername(username);
    Long lastRead = Long.MAX_VALUE;

    if (releaseUser != null) {
      lastRead = releaseUser.getLastReadId();
    } else {
      releaseUser = new ReleaseUserEntity();
      releaseUser.setUsername(username);
    }

    List<ReleaseNoteEntity> list = releaseNoteRepository.findByRoleAndLastRead(UserUtils.getUserDetails().getRole(),
        lastRead);

    if (lastRead.equals(Long.MAX_VALUE) || (list != null && list.size() > 0)) {

      lastRead = releaseNoteRepository.getMaxId();
      releaseUser.setLastReadId(lastRead);

      releaseUserRepository.save(releaseUser);
    }

    return list;
  }

}
