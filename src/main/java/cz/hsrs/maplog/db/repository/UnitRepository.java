package cz.hsrs.maplog.db.repository;

import cz.hsrs.maplog.db.entity.UnitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
@RepositoryRestResource(collectionResourceRel = "unit", path = "unit")
public interface UnitRepository extends PagingAndSortingRepository<UnitEntity, Long> {

    @Query("SELECT u FROM UnitEntity u, UnitToGroupEntity u2g " +
           "WHERE" +
            "     u2g.unit = u " +
            " AND u2g.userGroup.name = :name" +
            " AND u.isMobile = :isMobile")
    List<UnitEntity> findAllUnitByUser(@Param("name") String name, @Param("isMobile") Boolean isMobile );

    UnitEntity findAllUnitById(Long unitId);

    // List<UnitEntity> findAllUnitByUserName(@Param("name") String name);

    // List<UnitEntity> findAllUnitByUserName(@Param("name") String name);
}


