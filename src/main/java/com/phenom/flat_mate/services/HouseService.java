package com.phenom.flat_mate.services;

import com.phenom.flat_mate.common.HouseSearchCriteria;
import com.phenom.flat_mate.entities.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HouseService {
    Page<House> searchHouses(HouseSearchCriteria criteria);
}
