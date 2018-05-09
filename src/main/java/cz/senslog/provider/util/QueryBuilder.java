package cz.senslog.provider.util;

import cz.senslog.model.db.EntityQueryable;
import cz.senslog.provider.db.queryspecification.QuerySpecificationBuilder;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OK on 12/12/2017.
 */
@Component
public class QueryBuilder {

    private static final Pattern pattern;
    private static final List<SimpleDateFormat> dateFormats;

    static {
        // pattern = Pattern.compile("(\\w+?\\.?\\w+?)(:|<|>|~)(\\w+?),");
        pattern = Pattern.compile("([\\w\\.]+)(<|>|:)([\\w\\d- :]+)");

        // TODO: move this to application properties which TS format application will support
        dateFormats = new ArrayList<SimpleDateFormat>() {{
            add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS"));
            add(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            add(new SimpleDateFormat("yyyy-MM-dd"));
            add(new SimpleDateFormat("yyyy-MM"));
            add(new SimpleDateFormat("yyyy"));
        }};
    }



    public static Specification<EntityQueryable> build(String search){
        QuerySpecificationBuilder builder = new QuerySpecificationBuilder();
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {

            String value = matcher.group(3);

            // TODO the worst part of my code :(

            // try parse value as boolean
            Object objValue = BooleanUtils.toBooleanObject(value);
            if( objValue == null ){
                // try parse as long
                try {
                    objValue = Long.valueOf(value);
                } catch (NumberFormatException e) {}

                if( matcher.group(1).contains("time") ){
                    for (SimpleDateFormat simpleDateFormat : dateFormats) {
                        try {
                            objValue = new Timestamp(simpleDateFormat.parse(value).getTime());
                            break;
                        } catch (ParseException e1) {}
                    }
                }
            }

            // if no parser couldn't be able parse it, use it as string
            builder.with(matcher.group(1), matcher.group(2), objValue != null ? objValue : value);
        }

        return builder.build();
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


