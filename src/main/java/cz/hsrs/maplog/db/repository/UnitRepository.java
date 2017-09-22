package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UnitEntity;
import cz.hsrs.maplog.rest.dto.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
public interface UnitRepository extends JpaRepository<UnitEntity, Long> {


    // @Query("SELECT a FROM UnitEntity a WHERE a.name = :userName ")
    // List<UnitEntity> findAllUnitByUserName(@Param("userName") String nameUser);
}


