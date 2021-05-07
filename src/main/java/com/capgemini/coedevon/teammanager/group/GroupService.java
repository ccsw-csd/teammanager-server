package com.capgemini.coedevon.teammanager.group;

import java.util.List;

import com.capgemini.coedevon.teammanager.group.model.EditGroupDto;
import com.capgemini.coedevon.teammanager.group.model.GroupDto;
import com.capgemini.coedevon.teammanager.group.model.GroupEntity;
import com.capgemini.coedevon.teammanager.group.model.PublicGroupEntity;
import com.capgemini.coedevon.teammanager.group.model.RespuestaValidarBorradoDto;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
public interface GroupService {

  EditGroupDto getGroup(long id);

  /**
   * @param inicioNombre
   * @return
   */
  List<GroupEntity> getSubgroups(String name);

  List<PersonEntity> getPersons(String name);

  /**
   * @param data
   * @return
   */
  GroupEntity save(GroupDto data);

  /**
   * @param data
   * @return
   */
  RespuestaValidarBorradoDto validarUsuario(Long id);

  /**
   * @param data
   * @return
   */
  void borrarGrupo(Long data);

  /**
   * Recupera los grupos publicos del usuario conectado
   * @return
   */
  List<PublicGroupEntity> findPublicGroupsFromConnectedUser();

}
