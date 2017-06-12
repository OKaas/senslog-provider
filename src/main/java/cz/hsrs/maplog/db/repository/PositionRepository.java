package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.PositionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 6/12/2017.
 */

@RepositoryRestResource(path = "position")
public interface PositionRepository extends CrudRepository<PositionEntity, Long> {

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}


