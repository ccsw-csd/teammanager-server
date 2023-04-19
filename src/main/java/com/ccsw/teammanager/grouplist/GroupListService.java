package com.ccsw.teammanager.grouplist;

import java.util.List;

import com.ccsw.teammanager.grouplist.model.GroupListEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupListService {

    List<GroupListEntity> findAll(boolean adminView);

}
