package com.phenom.flat_mate.repository;

import com.phenom.flat_mate.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	// You can add custom queries if needed
}
