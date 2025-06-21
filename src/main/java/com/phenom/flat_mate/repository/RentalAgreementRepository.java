package com.phenom.flat_mate.repository;

import com.phenom.flat_mate.entities.RentalAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RentalAgreementRepository extends JpaRepository<RentalAgreement, Long> {
	List<RentalAgreement> findByOwnerId(String ownerId);

	List<RentalAgreement> findByHouseId(String houseId);

	List<RentalAgreement> findByCustomerId(String customerId);

	List<RentalAgreement> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

	List<RentalAgreement> findByEndDateBetween(LocalDate startDate, LocalDate endDate);

	List<RentalAgreement> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

	List<RentalAgreement> findByOwnerIdAndHouseId(String ownerId, String houseId);

	List<RentalAgreement> findByOwnerIdAndCustomerId(String ownerId, String customerId);

	List<RentalAgreement> findByHouseIdAndCustomerId(String houseId, String customerId);

	List<RentalAgreement> findByOwnerIdAndStartDateBetween(String ownerId, LocalDate startDate, LocalDate endDate);

	List<RentalAgreement> findByOwnerIdAndEndDateBetween(String ownerId, LocalDate startDate, LocalDate endDate);

	List<RentalAgreement> findByHouseIdAndStartDateBetween(String houseId, LocalDate startDate, LocalDate endDate);
}