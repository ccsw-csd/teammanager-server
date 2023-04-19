package com.ccsw.teammanager.grouplist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsw.teammanager.grouplist.model.GroupListEntity;

@Repository
public interface GroupListRepository extends CrudRepository<GroupListEntity, Long> {

    @Override
    List<GroupListEntity> findAll();

    @Query(value = "select * from v_group_list vgl where id in (select gm.group_id from group_manager gm join person p on gm.person_id = p.id where p.username = :username)", nativeQuery = true)
    public List<GroupListEntity> findManagedGroups(@Param("username") String username);

}
