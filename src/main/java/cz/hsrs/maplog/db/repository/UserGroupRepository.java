package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
public interface UserGroupRepository extends CrudRepository<UserGroupEntity, Long> {

    List<UserGroupEntity> findByUsers_Name(String userName);

    /**
     * Return parent user group
     *
     * @param name
     * @return
     */
    // somehow default name of method does not do what I except :)
    @Query("SELECT a.userGroup FROM UserGroupEntity a WHERE a.name = :name")
    UserGroupEntity findParentUserGroupByName(@Param("name") String name);

    /**
     * Return all child user groups
     *
     * @param name
     * @return
     */
    @Query("SELECT b FROM UserGroupEntity a, UserGroupEntity b WHERE a.name = :name AND b.userGroup = a.id")
    List<UserGroupEntity> findChildUserGroupByName(@Param("name") String name);
}
