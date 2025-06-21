package com.phenom.flat_mate.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RentalAgreement {
	private String ownerId;
	private String houseId;
	private String customerId;
	private LocalDate startDate;
	private LocalDate endDate;
	private BigDecimal price;
	String documentPath;
}