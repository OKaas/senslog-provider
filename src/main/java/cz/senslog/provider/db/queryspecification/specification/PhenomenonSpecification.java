package cz.senslog.provider.db.queryspecification.specification;


import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.PhenomenonEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.util.Set;

/**
 * Created by OK on 1/18/2018.
 */
public class PhenomenonSpecification {

    public static Specification<EntityQueryable> matchPhenomenonForUnitInGroup(final Set<Long> groupId){
        return (root, query, builder) -> {
            final Path<PhenomenonEntity> group = root
                    .joinList("sensors")
                    .join("unit")
                    .join("unitGroup")
                    .joinList("user2unitGroups")
                    .get("id");

            query.groupBy(root.get("id"));

            return group.in(groupId);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


