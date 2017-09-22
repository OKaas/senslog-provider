package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
public interface UserGroupRepository extends JpaRepository<UserGroupEntity, Long> {

    UserGroupEntity findByName(@Param("name") String name);

    @Query("SELECT a FROM UserGroupEntity a, UserGroupEntity b WHERE b.name = :name AND b.userGroup = a")
    UserGroupEntity findParentGroupByName(@Param("name") String name);
}

