package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.UnitEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Set;

/**
 * Created by OK on 12/13/2017.
 */
public class UnitInUserGroup {

    public static Specification<EntityQueryable> matchUnitInUserGroup(final Set<Long> groupIds){
        return (root, query, builder) -> {
            final Path<UnitEntity> group = root.join("unitToGroups").join("userGroup").get("id");
            return group.in(groupIds);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}


