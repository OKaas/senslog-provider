package cz.hsrs.maplog.db.repository;


import cz.hsrs.maplog.db.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OK on 6/12/2017.
 */
public interface PositionRepository extends JpaRepository<PositionEntity, Long> {

    /* --- Collaborates --- */


    List<PositionEntity> findByUnitId(@Param("unitId") Long unitId);

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


