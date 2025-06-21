package com.phenom.flat_mate.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PagingUtils{
    private PagingUtils() {

    }

    public static Pageable getPageable(final PagingCriteria criteria) {

        if (criteria == null) {
            return Pageable.unpaged();
        }

        if (criteria.getSortKey() != null) {

            Sort.Direction d = Sort.Direction.DESC;

            if (criteria.getSortDirection() != null && criteria.getSortDirection().equals("asc")) {
                d = Sort.Direction.ASC;
            }

            return PageRequest.of(criteria.getPageNo(), criteria.getPageSize(), Sort.by(d, criteria.getSortKey()));
        }

        return PageRequest.of(criteria.getPageNo(), criteria.getPageSize());
    }
}
