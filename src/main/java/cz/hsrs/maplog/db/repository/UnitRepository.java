package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.model.UnitEntity;
import cz.hsrs.maplog.security.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;
import java.util.Set;

/**
 * Created by OK on 7/4/2017.
 */
@RepositoryRestResource(collectionResourceRel = "unit", path = "unit")
public interface UnitRepository extends JpaRepository<UnitEntity, Long> {

    /**
     * Get all units which are attached to Groups
     *
     * @param id
     * @return
     */
    List<UnitEntity> findAllByUnitToGroupsUserGroupIdIn(@Param("id") Set<Long> id);

    List<UnitEntity> findAllByUnitToGroupsUserGroupId(@Param("id") Long id);

    List<UnitEntity> findAll(@AuthenticationPrincipal UserToken userToken);

    UnitEntity findAllUnitByIdAndUnitToGroupsUserGroupIdIn(@Param("unitId") Long unitId, @Param("id")Set<Long> id );

    // List<UnitEntity> findAllUnitByUserName(@Param("username") String username);

    // List<UnitEntity> findAllUnitByUserName(@Param("username") String username);
}


