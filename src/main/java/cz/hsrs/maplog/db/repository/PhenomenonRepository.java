package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.PhenomenonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by OK on 9/14/2017.
 */
@RepositoryRestResource(collectionResourceRel = "phenomenon", path = "phenomenon")
public interface PhenomenonRepository extends JpaRepository<PhenomenonEntity, Long> {
}
