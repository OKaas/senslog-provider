package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.ObservationEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.util.Set;

public class MetadataSpecification {
    public static Specification<EntityQueryable> matchMetadataForUnitInUserGroup(final Set<Long> unitGroup){
        return (root, query, builder) -> {
            final Path<ObservationEntity> group = root
                    .join("sensors")
                    .join("unit")
                    .join("unitGroup")
                    .joinList("user2unitGroups")
                    .get("id");

            query.groupBy(root.get("id"));

            return group.in(unitGroup);
        };
    }
}
