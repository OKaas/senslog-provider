package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.PositionEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.util.Set;

/**
 * Created by OK on 12/15/2017.
 */
public class PositionSpecification {

    public static Specification<EntityQueryable> matchPositionForUnitInGroup(final Set<Long> groupId){
        return (root, query, builder) -> {
            final Path<PositionEntity> group = root
                    .join("unit")
                    .join("unitGroup")
                    .join("user2unitGroups")
                    .join("unitGroup")
                    .get("id");

            query.groupBy(root.get("id"));

            return group.in(groupId);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


