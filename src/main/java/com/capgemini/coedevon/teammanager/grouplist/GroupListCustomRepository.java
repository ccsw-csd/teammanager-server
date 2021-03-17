package com.capgemini.coedevon.teammanager.grouplist;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;

import com.capgemini.coedevon.teammanager.grouplist.model.GroupListEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupListCustomRepository {
  Page<GroupListEntity> findAllGroupListWithPagination(Pageable pageable, String username);

}
