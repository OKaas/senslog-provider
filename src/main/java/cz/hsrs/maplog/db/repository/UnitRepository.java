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

}


