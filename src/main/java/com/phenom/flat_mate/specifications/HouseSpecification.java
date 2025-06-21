package com.phenom.flat_mate.specifications;
import com.phenom.flat_mate.common.HouseSearchCriteria;
import com.phenom.flat_mate.entities.House;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.*;

public class HouseSpecification {
    public static Specification<House> build(HouseSearchCriteria criteria) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (criteria.getLocation() != null) {
                predicate = cb.and(predicate,
                        cb.like(cb.lower(root.get("location")), "%" + criteria.getLocation().toLowerCase() + "%"));
            }

            if (criteria.getStatus() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("status"), criteria.getStatus()));
            }

            if (criteria.getRtype() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("rtype"), criteria.getRtype()));
            }

            if (criteria.getFurnished() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("furnished"), criteria.getFurnished()));
            }

            if (criteria.getOwnerId() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("owner").get("id"), criteria.getOwnerId()));
            }

            return predicate;
        };
    }
}
