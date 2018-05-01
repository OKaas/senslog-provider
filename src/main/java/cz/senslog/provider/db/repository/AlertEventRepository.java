package cz.senslog.provider.db.repository;

import cz.senslog.model.db.EventEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 1/21/2018.
 */
@RepositoryRestResource(collectionResourceRel = "alertEvent", path = "alertEvent")
public interface AlertEventRepository extends PagingAndSortingRepository<EventEntity, Long>, JpaSpecificationExecutor {

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


