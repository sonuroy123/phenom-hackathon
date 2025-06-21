package com.phenom.flat_mate.repository;

import com.phenom.flat_mate.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer>, JpaSpecificationExecutor<House> {
}
