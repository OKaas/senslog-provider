package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OK on 9/14/2017.
 */
public interface SensorRepository extends JpaRepository<SensorEntity, Long> {

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}
