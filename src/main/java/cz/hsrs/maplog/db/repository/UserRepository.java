package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by OK on 7/3/2017.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}

