package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.SensorEntity;
import cz.hsrs.maplog.db.model.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
@RepositoryRestResource(collectionResourceRel = "userGroup", path = "userGroup")
public interface UserGroupRepository extends PagingAndSortingRepository<SensorEntity, Long>, JpaSpecificationExecutor {
}

