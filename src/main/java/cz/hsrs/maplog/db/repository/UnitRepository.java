package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UnitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
public interface UnitRepository extends CrudRepository<UnitEntity, Long> {

    // @Query("SELECT a FROM UnitEntity a WHERE a.name = :userName ")
    // List<UnitEntity> findAllUnitByUserName(@Param("userName") String nameUser);
}


