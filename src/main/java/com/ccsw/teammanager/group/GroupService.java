package com.ccsw.teammanager.group;

import java.util.List;

import com.ccsw.teammanager.group.dto.EditGroupDto;
import com.ccsw.teammanager.group.dto.GroupDto;
import com.ccsw.teammanager.group.model.GroupEntity;
import com.ccsw.teammanager.group.model.GroupListEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupService {

    /**
     * Recupera un grupo para su edición
     * @param id
     * @return
     */
    EditGroupDto getGroup(long id);

    /**
     * Recupera un listado de grupos por su nombre
     * @param name
     * @return
     */
    List<GroupEntity> getSubgroups(String name);

    /**
     * Guarda la información de un grupo
     * @param data
     * @return
     */
    GroupEntity save(GroupDto data);

    /**
     * Recupera los grupos
     * @param adminView
     * @return
     */
    List<GroupListEntity> findAll(boolean adminView);
}
