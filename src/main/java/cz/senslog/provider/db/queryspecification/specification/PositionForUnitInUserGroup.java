package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.provider.db.model.EntityQueryable;
import cz.senslog.provider.db.model.PositionEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

/**
 * Created by OK on 12/15/2017.
 */
public class PositionForUnitInUserGroup {

    public static Specification<EntityQueryable> matchPositionForUnitInUserGroup(final Long groupId){
        return (root, query, builder) -> {
            final Path<PositionEntity> group = root.join("unit").join("unitToGroups").join("userGroup").get("id");
            return group.in(groupId);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


