package cz.hsrs.maplog.db.queryspecification.specification;

import cz.hsrs.maplog.db.model.SensorEntity;
import cz.hsrs.maplog.db.queryspecification.EntityQueryable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

/**
 * Created by OK on 1/20/2018.
 */
public class SensorForUnitInUserGroup {

    public static Specification<EntityQueryable> matchSensorForUnitInUserGroup(final Long groupId){
        return (root, query, builder) -> {
            final Path<SensorEntity> group = root.join("unit").join("unitToGroups").join("userGroup").get("id");
            return group.in(groupId);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


