package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UserGroupEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
public interface GroupsRepository extends CrudRepository<UserGroupEntity, Long> {

    List<UserGroupEntity> findBySystemUsers_UserName(String userName);
}
