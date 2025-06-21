package com.phenom.flat_mate.serviceImpl;

import com.phenom.flat_mate.entities.RentalAgreement;
import com.phenom.flat_mate.repository.RentalAgreementRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RentalAgreementServiceImpl {
	private final RentalAgreementRepository rentalAgreementRepository;

	public RentalAgreementServiceImpl(RentalAgreementRepository rentalAgreementRepository) {
		this.rentalAgreementRepository = rentalAgreementRepository;
	}

	public RentalAgreement findByOwnerId(String ownerId) {
		// Example: return the first agreement for the owner, or null if none found
		List<RentalAgreement> agreements = rentalAgreementRepository.findByOwnerId(ownerId);
		return agreements.isEmpty() ? null : agreements.get(0);
	}

	public void createRentalAgreement(String ownerId, String houseId, String customerId, LocalDate startDate,
			LocalDate endDate, BigDecimal price, String documentPath) {
		RentalAgreement rentalAgreement = new RentalAgreement();
		rentalAgreement.setOwnerId(ownerId);
		rentalAgreement.setHouseId(houseId);
		rentalAgreement.setCustomerId(customerId);
		rentalAgreement.setStartDate(startDate);
		rentalAgreement.setEndDate(endDate);
		rentalAgreement.setPrice(price);
		rentalAgreement.setDocumentPath(documentPath); // Set the document path if needed
		rentalAgreementRepository.save(rentalAgreement);
	}

	// Other methods...
	public List<RentalAgreement> findByHouseId(String houseId) {
		return rentalAgreementRepository.findByHouseId(houseId);
	}
	public List<RentalAgreement> findByCustomerId(String customerId) {
		return rentalAgreementRepository.findByCustomerId(customerId);
	}
	public List<RentalAgreement> findByStartDateBetween(LocalDate startDate, LocalDate endDate) {
		return rentalAgreementRepository.findByStartDateBetween(startDate, endDate);
	}
	public List<RentalAgreement> findByEndDateBetween(LocalDate startDate, LocalDate endDate) {
		return rentalAgreementRepository.findByEndDateBetween(startDate, endDate);
	}
	public List<RentalAgreement> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
		return rentalAgreementRepository.findByPriceBetween(minPrice, maxPrice);
	}
	public List<RentalAgreement> findByOwnerIdAndHouseId(String ownerId, String houseId) {
		return rentalAgreementRepository.findByOwnerIdAndHouseId(ownerId, houseId);
	}
	public List<RentalAgreement> findByOwnerIdAndCustomerId(String ownerId, String customerId) {
		return rentalAgreementRepository.findByOwnerIdAndCustomerId(ownerId, customerId);
	}
	public List<RentalAgreement> findByHouseIdAndCustomerId(String houseId, String customerId) {
		return rentalAgreementRepository.findByHouseIdAndCustomerId(houseId, customerId);
	}
	public List<RentalAgreement> findByOwnerIdAndStartDateBetween(String ownerId, LocalDate startDate, LocalDate endDate) {
		return rentalAgreementRepository.findByOwnerIdAndStartDateBetween(ownerId, startDate, endDate);
	}
	public List<RentalAgreement> findByOwnerIdAndEndDateBetween(String ownerId, LocalDate startDate, LocalDate endDate) {
		return rentalAgreementRepository.findByOwnerIdAndEndDateBetween(ownerId, startDate, endDate);
	}
	public List<RentalAgreement> findByHouseIdAndStartDateBetween(String houseId, LocalDate startDate, LocalDate endDate) {
		return rentalAgreementRepository.findByHouseIdAndStartDateBetween(houseId, startDate, endDate);
	}

}