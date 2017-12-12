package cz.hsrs.maplog.util;

import cz.hsrs.maplog.db.queryspecification.EntityQueryable;
import cz.hsrs.maplog.db.queryspecification.QuerySpecificationBuilder;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OK on 12/12/2017.
 */
@Component
public class QueryBuilder {

    public static Specification<EntityQueryable> build(String search){
        QuerySpecificationBuilder builder = new QuerySpecificationBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>|~)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {

            // try parse value as boolean
            Object value = BooleanUtils.toBooleanObject(matcher.group(3));
            if( value == null ){
                value = Long.valueOf(matcher.group(3));
            }

            builder.with(matcher.group(1), matcher.group(2), value != null ? value : matcher.group(3));
        }
        // LOGGER.info("> userToken: {}", details);

        return builder.build();
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


