package cz.hsrs.maplog.db.queryspecification;

import cz.hsrs.maplog.rest.RestMapping;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Timestamp;

/**
 * Created by OK on 12/12/2017.
 */
public class QuerySpecification<T> implements Specification<T> {

    private static final String DELIMITER = "\\.";
    private SearchCriteria criteria;

    public QuerySpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        String[] tok = criteria.getKey().split(DELIMITER);

        // filter on child object
        // child predicate (something.something.property)
        if(tok.length > 1){

            // dot notation
            // add all join tables from the second
            Join<Object, Object> joins = root.join(tok[0]);
            for(int i = 1; i < tok.length - 1; ++i){
                joins = joins.join( tok[i] );
            }
            Path p = joins.get(tok[ tok.length - 1]);

            if (criteria.getOperation().equalsIgnoreCase(">")) {
                return builder.greaterThanOrEqualTo(
                        p, criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase("<")) {
                return builder.lessThanOrEqualTo(
                        p, criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (p.getJavaType() == String.class) {
                    return builder.like(
                            p, "%" + criteria.getValue() + "%");
                } else {
                    return builder.equal(p, criteria.getValue());
                }
            }

        // filter on current object
        } else {
            Object obj = criteria.getValue();

            if( obj instanceof Timestamp ){
                if (criteria.getOperation().equalsIgnoreCase(">")) {
                    return builder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()),
                            builder.function("TO_DATE",
                                    Timestamp.class,
                                    builder.literal(criteria.getValue().toString()), builder.literal(RestMapping.PATTERN_TIMESTAMP)
                            )
                    );
                }
                else if (criteria.getOperation().equalsIgnoreCase("<")) {
                    return builder.lessThanOrEqualTo(
                            root.get(criteria.getKey()),
                            builder.function("TO_DATE",
                                    Timestamp.class,
                                    builder.literal(criteria.getValue().toString()), builder.literal(RestMapping.PATTERN_TIMESTAMP)
                            )
                    );
                }
                else if (criteria.getOperation().equalsIgnoreCase(":")) {
                    if (root.get(criteria.getKey()).getJavaType() == String.class) {
                        return builder.like(
                                root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                    } else {
                        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                    }
                }
            }

            if (criteria.getOperation().equalsIgnoreCase(">")) {
                return builder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase("<")) {
                return builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    return builder.like(
                            root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                } else {
                    return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                }
            }
        }

        return null;
    }
}


