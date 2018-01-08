package cz.hsrs.maplog.db.queryspecification.specification;

import cz.hsrs.maplog.db.model.PositionEntity;
import cz.hsrs.maplog.db.queryspecification.EntityQueryable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.util.Set;

/**
 * Created by OK on 12/15/2017.
 */
public class PositionForUnitInUserGroup {

    public static Specification<EntityQueryable> matchPositionForUnitInUserGroup(final Set<Long> groupIds){
        return (root, query, builder) -> {
            final Path<PositionEntity> group = root.join("unit").join("unitToGroups").join("userGroup").get("id");
            return group.in(groupIds);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


