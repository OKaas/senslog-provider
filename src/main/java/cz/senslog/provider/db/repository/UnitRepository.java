package cz.senslog.provider.db.repository;

import cz.senslog.model.db.UnitEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 7/4/2017.
 */
@RepositoryRestResource(collectionResourceRel = "unit", path = "unit")
public interface UnitRepository extends PagingAndSortingRepository<UnitEntity, Long>, JpaSpecificationExecutor {

}


