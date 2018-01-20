package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.PhenomenonEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 9/14/2017.
 */
@RepositoryRestResource(collectionResourceRel = "phenomenon", path = "phenomenon")
public interface PhenomenonRepository extends PagingAndSortingRepository<PhenomenonEntity, Long>, JpaSpecificationExecutor {
    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}
