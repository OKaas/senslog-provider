package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OK on 7/3/2017.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}


