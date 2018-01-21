package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.AlertEventEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 1/21/2018.
 */
@RepositoryRestResource(collectionResourceRel = "alertEvent", path = "alertEvent")
public interface AlertEventRepository extends PagingAndSortingRepository<AlertEventEntity, Long>, JpaSpecificationExecutor {

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


