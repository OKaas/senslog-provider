package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.SensorEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.util.Set;

/**
 * Created by OK on 1/20/2018.
 */
public class SensorSpecification {

    public static Specification<EntityQueryable> matchSensorForUnitInGroup(final Set<Long> groupId){
        return (root, query, builder) -> {
            final Path<SensorEntity> group = root
                    .join("unit")
                    .join("unitGroup")
                    .join("user2unitGroups")
                    .join("unitGroup")
                    .get("id");

            query.groupBy(root.get("id"));

            return group.in(groupId);
        };
    }

    public static Specification<EntityQueryable> matchUnitById(final Long sensorId){
        return (root, query, builder) -> root.get("id").in(sensorId);
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


