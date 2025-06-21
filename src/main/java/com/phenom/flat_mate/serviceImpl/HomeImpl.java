package com.phenom.flat_mate.serviceImpl;

import com.phenom.flat_mate.common.HouseSearchCriteria;
import com.phenom.flat_mate.common.PagingUtils;
import com.phenom.flat_mate.entities.House;
import com.phenom.flat_mate.repository.HouseRepository;
import com.phenom.flat_mate.services.HouseService;
import com.phenom.flat_mate.specifications.HouseSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Optional;

@Service
public class HomeImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Override
    @Transient()
    public Page<House> searchHouses(HouseSearchCriteria criteria) {
        Specification<House> spec = HouseSpecification.build(criteria);

        Pageable pageable = PagingUtils.getPageable(criteria.getPagingCriteria());

        return this.houseRepository.findAll(HouseSpecification.build(criteria), pageable);
    }


}
