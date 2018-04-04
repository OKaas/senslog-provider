package cz.senslog.provider.db.queryspecification.specification;

import cz.senslog.provider.db.model.EntityQueryable;
import cz.senslog.provider.db.model.EnumItemEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

/**
 * Created by OK on 1/21/2018.
 */
public class EnumItemByName{

    public static Specification<EntityQueryable> matchEnumItemByName(final String enumName){
        return (root, query, builder) -> {
            final Path<EnumItemEntity> group = root.get("name");
            return group.in(enumName);
        };
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


