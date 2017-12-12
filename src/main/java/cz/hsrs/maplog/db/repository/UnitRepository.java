package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.UnitEntity;
//import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.db.queryspecification.EntityQueryable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * Created by OK on 7/4/2017.
 */
@RepositoryRestResource(collectionResourceRel = "unit", path = "unit")
public interface UnitRepository extends JpaRepository<UnitEntity, Long>, JpaSpecificationExecutor {

    /**
     * Get all units which are attached to Groups
     *
     * @param id
     * @return
     */
    List<UnitEntity> findAllByUnitToGroupsUserGroupIdIn(@Param("id") Set<Long> id);

    List<UnitEntity> findAllByUnitToGroupsUserGroupId(Long userGroupId, Specification<EntityQueryable> spec);

    List<UnitEntity> findAllByUnitToGroupsUserGroupId(Long userGroupId);

    List<UnitEntity> findAllByUnitToGroupsUserGroupId(@Param("search") String search);

    UnitEntity findAllUnitByIdAndUnitToGroupsUserGroupIdIn(@Param("unitId") Long unitId, @Param("id")Set<Long> id );

    // List<UnitEntity> findAllUnitByUserName(@Param("username") String username);

    // List<UnitEntity> findAllUnitByUserName(@Param("username") String username);
}


