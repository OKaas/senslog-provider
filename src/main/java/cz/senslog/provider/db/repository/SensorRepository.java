package cz.senslog.provider.db.repository;

import cz.senslog.provider.db.model.SensorEntity;
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
