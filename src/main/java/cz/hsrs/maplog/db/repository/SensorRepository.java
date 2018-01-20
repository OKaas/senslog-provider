package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.SensorEntity;
import cz.hsrs.maplog.db.model.UnitEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 9/14/2017.
 */
@RepositoryRestResource(collectionResourceRel = "sensor", path = "sensor")
public interface SensorRepository extends PagingAndSortingRepository<SensorEntity, Long>, JpaSpecificationExecutor {

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}
