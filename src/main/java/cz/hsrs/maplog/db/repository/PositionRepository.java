package cz.hsrs.maplog.db.repository;


import cz.hsrs.maplog.db.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OK on 6/12/2017.
 */
public interface PositionRepository extends JpaRepository<PositionEntity, Long> {

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


