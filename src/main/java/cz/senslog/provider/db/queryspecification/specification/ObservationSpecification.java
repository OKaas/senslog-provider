package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.ObservationEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.util.List;
import java.util.Set;

/**
 * Created by OK on 1/20/2018.
 */
public class ObservationSpecification {

    public static Specification<EntityQueryable> matchObservationForUnitInUserGroup(final Set<Long> unitGroup){
        return (root, query, builder) -> {
            final Path<ObservationEntity> group = root
                    .join("sensor")
                    .join("unit")
                    .join("unitGroup")
                    .joinList("user2unitGroups")
                    .get("id");

            query.groupBy(root.get("id"));

            return group.in(unitGroup);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


