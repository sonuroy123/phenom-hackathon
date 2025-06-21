package com.phenom.flat_mate.controller;

import com.phenom.flat_mate.common.HouseSearchCriteria;
import com.phenom.flat_mate.entities.House;
import com.phenom.flat_mate.services.HouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/houses")
class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/search")
    public ResponseEntity<Page<House>> searchHouses(
            @RequestBody HouseSearchCriteria criteria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<House> result = houseService.searchHouses(criteria, pageable);
        return ResponseEntity.ok(result);
    }
}
