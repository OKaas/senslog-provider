package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 6/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "alert", path = "alert")
public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
}
