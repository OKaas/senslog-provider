package cz.hsrs.maplog.db.queryspecification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.regex.Pattern;

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

        Join<Object, Object> joins = null;
        // filter on child object
        // child predicate (something.something.property)
        if(tok.length == 2){
            joins = root.join(tok[0]);

            if (criteria.getOperation().equalsIgnoreCase(">")) {
                return builder.greaterThanOrEqualTo(
                        joins.get(criteria.getKey()), criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase("<")) {
                return builder.lessThanOrEqualTo(
                        joins.get(criteria.getKey()), criteria.getValue().toString());
            }
            else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (joins.get(tok[1]).getJavaType() == String.class) {
                    return builder.like(
                            joins.get(tok[1]), "%" + criteria.getValue() + "%");
                } else {
                    return builder.equal(joins.get(tok[1]), criteria.getValue());
                }
            }

        // filter on current object
        } else {
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


