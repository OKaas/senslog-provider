package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.provider.db.model.EntityQueryable;
import org.springframework.data.jpa.domain.Specification;


/**
 * Created by OK on 1/8/2018.
 */
public class UnitById {

    public static Specification<EntityQueryable> matchUnitById(final Long unitId){
        return (root, query, builder) -> root.get("id").in(unitId);
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


