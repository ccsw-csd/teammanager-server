package com.ccsw.teammanager.group;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsw.teammanager.group.model.GroupManagerEntity;
import com.ccsw.teammanager.person.model.PersonEntity;

/**
 * TODO apastorm This type ...
 *
 */
@Repository
public interface GroupManagerRepository extends CrudRepository<GroupManagerEntity, Long> {

    /**
     * @param id
     * @return
     */
    @Query(value = "select p from PersonEntity p where p.id in (select gman.person_id from GroupManagerEntity gman where gman.group_id = :id)")
    public List<PersonEntity> findManagersByGroupId(@Param("id") long id);

    /**
     * @param id
     */
    @Modifying
    @Query(value = "delete from GroupManagerEntity where group_id = :id")
    void deleteByGroupId(Long id);
}
