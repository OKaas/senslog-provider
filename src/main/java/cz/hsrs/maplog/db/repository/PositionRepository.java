package cz.hsrs.maplog.db.repository;


import cz.hsrs.maplog.db.model.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

/**
 * Created by OK on 6/12/2017.
 */
@RepositoryRestResource(collectionResourceRel = "positon", path = "position")
public interface PositionRepository extends JpaRepository<PositionEntity, Long>, JpaSpecificationExecutor {

    /* --- Collaborates --- */


    List<PositionEntity> findAllByUnitIdAndUnitUnitToGroupsUserGroupIdIn(@Param("unitId") Long unitId, @Param("") Set<Long> groupId);

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


