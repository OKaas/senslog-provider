package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 9/14/2017.
 */
@RepositoryRestResource(collectionResourceRel = "sensor", path = "sensor")
public interface SensorRepository extends JpaRepository<SensorEntity, Long> {

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}
