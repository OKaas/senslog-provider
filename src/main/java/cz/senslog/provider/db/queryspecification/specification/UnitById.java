package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.model.db.EntityQueryable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;


/**
 * Created by OK on 1/8/2018.
 */
public class UnitById {

    public static Specification<EntityQueryable> matchUnitById(final Long unitId){
        return (root, query, builder) -> root.get("id").in(unitId);
    }

    public static Specification<EntityQueryable> matchUnitByIds(final Set<Long> unitId){
        return (root, query, builder) -> root.get("id").in(unitId);
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


