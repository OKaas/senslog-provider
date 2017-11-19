package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
@RepositoryRestResource(collectionResourceRel = "userGroup", path = "userGroup")
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long>, JpaSpecificationExecutor<UserGroupEntity> {

    // UserGroupEntity getUserGroupById(@Param("id") Long id);

//    @Query("SELECT p_grp.userGroup FROM UserGroupEntity p_grp WHERE p_grp.id = :id ")
//    UserGroupEntity getParentUserGroupById(@Param("id") Long id);

    @Query("SELECT p_grp.userGroups FROM UserGroupEntity p_grp WHERE p_grp.id = :id")
    List<UserGroupEntity> getChildUserGroupById(@Param("id") Long id);
}

