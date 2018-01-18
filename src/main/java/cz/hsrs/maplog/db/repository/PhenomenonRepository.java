package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.PhenomenonEntity;
import cz.hsrs.maplog.db.model.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 9/14/2017.
 */
@RepositoryRestResource(collectionResourceRel = "phenomenon", path = "phenomenon")
public interface PhenomenonRepository extends JpaRepository<PhenomenonEntity, Long>, JpaSpecificationExecutor {
}
