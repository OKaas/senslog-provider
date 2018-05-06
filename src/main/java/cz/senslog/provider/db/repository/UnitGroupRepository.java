package cz.senslog.provider.db.repository;

import cz.senslog.model.db.UnitGroupEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "unitGroup", path = "unitGroup")
public interface UnitGroupRepository extends PagingAndSortingRepository<UnitGroupEntity, Long>, JpaSpecificationExecutor {
}
