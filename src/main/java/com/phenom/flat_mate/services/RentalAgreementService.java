package com.phenom.flat_mate.services;

import com.phenom.flat_mate.dto.RentalAgreement;
import java.time.LocalDate;
import java.util.List;

public interface RentalAgreementService {
    void createRentalAgreement(RentalAgreement agreement);
    RentalAgreement findByOwnerId(String ownerId);
    List<RentalAgreement> findByHouseId(String houseId);
    List<RentalAgreement> findByCustomerId(String customerId);
    List<RentalAgreement> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
    List<RentalAgreement> findByEndDateBetween(LocalDate startDate, LocalDate endDate);
}
