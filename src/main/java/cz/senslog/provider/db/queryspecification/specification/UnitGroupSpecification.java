package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.model.db.UnitEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import java.util.Set;

public class UnitGroupSpecification {
    public static Specification<EntityQueryable> matchUnitGroupGroupByUnitGroup(final Set<Long> groupIds){
        return (root, query, builder) -> {
            final Path<UnitEntity> group = root.get("id");
            return group.in(groupIds);
        };
    }
}
