package com.phenom.flat_mate.controller;

import com.phenom.flat_mate.entities.RentalAgreement;
import com.phenom.flat_mate.serviceImpl.RentalAgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rental-agreements")
public class RentalAgreementController {
    @Autowired
    private RentalAgreementServiceImpl rentalAgreementServiceImpl;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> createRentalAgreement(
            @RequestPart("agreement") RentalAgreement agreement,
            @RequestPart(value = "document", required = false) MultipartFile document
    ) {
        String documentPath = null;
        if (document != null && !document.isEmpty()) {
            // Save the file to a directory (e.g., /uploads/)
            try {
                String uploadsDir = "uploads/";
                java.nio.file.Path uploadPath = java.nio.file.Paths.get(uploadsDir);
                if (!java.nio.file.Files.exists(uploadPath)) {
                    java.nio.file.Files.createDirectories(uploadPath);
                }
                String fileName = System.currentTimeMillis() + "_" + document.getOriginalFilename();
                java.nio.file.Path filePath = uploadPath.resolve(fileName);
                document.transferTo(filePath.toFile());
                documentPath = filePath.toString();
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }
        rentalAgreementServiceImpl.createRentalAgreement(
                agreement.getOwnerId(),
                agreement.getHouseId(),
                agreement.getCustomerId(),
                agreement.getStartDate(),
                agreement.getEndDate(),
                agreement.getPrice(),
                documentPath
        );
        return ResponseEntity.ok().build();
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<RentalAgreement>> getByOwner(@PathVariable String ownerId) {
        RentalAgreement agreement = rentalAgreementServiceImpl.findByOwnerId(ownerId);
        return agreement == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(List.of(agreement));
    }

    @GetMapping("/house/{houseId}")
    public ResponseEntity<List<RentalAgreement>> getByHouse(@PathVariable String houseId) {
        return ResponseEntity.ok(rentalAgreementServiceImpl.findByHouseId(houseId));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<RentalAgreement>> getByCustomer(@PathVariable String customerId) {
        return ResponseEntity.ok(rentalAgreementServiceImpl.findByCustomerId(customerId));
    }

    @GetMapping("/start-date")
    public ResponseEntity<List<RentalAgreement>> getByStartDateRange(@RequestParam String start, @RequestParam String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return ResponseEntity.ok(rentalAgreementServiceImpl.findByStartDateBetween(startDate, endDate));
    }

    @GetMapping("/end-date")
    public ResponseEntity<List<RentalAgreement>> getByEndDateRange(@RequestParam String start, @RequestParam String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return ResponseEntity.ok(rentalAgreementServiceImpl.findByEndDateBetween(startDate, endDate));
    }
}
