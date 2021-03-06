package cz.senslog.provider.db.repository;

import cz.senslog.model.db.SensorEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by OK on 7/3/2017.
 */
@RepositoryRestResource(collectionResourceRel = "userGroup", path = "userGroup")
public interface UserGroupRepository extends PagingAndSortingRepository<SensorEntity, Long>, JpaSpecificationExecutor {
}

