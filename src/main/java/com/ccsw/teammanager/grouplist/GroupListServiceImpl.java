package com.ccsw.teammanager.grouplist;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.config.security.UserUtils;
import com.ccsw.teammanager.grouplist.model.GroupListEntity;

/**
 *
 *
 */
@Service
@Transactional
public class GroupListServiceImpl implements GroupListService {

    @Autowired
    GroupListRepository groupListRepository;

    @Override
    public List<GroupListEntity> findAll(boolean adminView) {
        if (userIsAdmin() && adminView) {
            return this.groupListRepository.findAll();
        }

        return this.groupListRepository.findManagedGroups(UserUtils.getUserDetails().getUsername());
    }

    /**
     * @return
     */
    private boolean userIsAdmin() {

        return UserUtils.hasRole("ADMIN");
    }

}
