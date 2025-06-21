package com.phenom.flat_mate.serviceImpl;

import com.phenom.flat_mate.common.HouseSearchCriteria;
import com.phenom.flat_mate.entities.House;
import com.phenom.flat_mate.repository.HouseRepository;
import com.phenom.flat_mate.services.HouseService;
import com.phenom.flat_mate.specifications.HouseSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class HomeImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Override
    public Page<House> searchHouses(HouseSearchCriteria criteria, Pageable pageable) {
        Specification<House> spec = HouseSpecification.build(criteria);
        return houseRepository.findAll(spec, pageable);
    }


}
