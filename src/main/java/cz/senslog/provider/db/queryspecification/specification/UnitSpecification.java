package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.UnitEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.util.Set;


/**
 * Created by OK on 1/8/2018.
 */
public class UnitSpecification {

    public static Specification<EntityQueryable> matchUnitById(final Long unitId){
        return (root, query, builder) -> root.get("id").in(unitId);
    }

    public static Specification<EntityQueryable> matchUnitByIds(final Set<Long> unitId){
        return (root, query, builder) -> root.get("id").in(unitId);
    }

    public static Specification<EntityQueryable> matchUnitInUserGroup(final Set<Long> groupIds){
        return (root, query, builder) -> {
            final Path<UnitEntity> group = root
                    .join("unitGroup")
                    .join("user2unitGroups")
                    .join("unitGroup")
                    .get("id");

            query.groupBy(root.get("id"));
            return group.in(groupIds);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


