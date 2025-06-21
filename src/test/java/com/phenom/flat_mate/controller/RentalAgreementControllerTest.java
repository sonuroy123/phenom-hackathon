package com.phenom.flat_mate.controller;

import com.phenom.flat_mate.dto.RentalAgreement;
import com.phenom.flat_mate.serviceImpl.RentalAgreementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RentalAgreementControllerTest {
    private MockMvc mockMvc;

    @Mock
    private RentalAgreementServiceImpl rentalAgreementServiceImpl;

    @InjectMocks
    private RentalAgreementController rentalAgreementController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rentalAgreementController).build();
    }

    @Test
    void testCreateRentalAgreementWithDocument() throws Exception {
        RentalAgreement agreement = new RentalAgreement();
        agreement.setOwnerId("owner1");
        agreement.setHouseId("house1");
        agreement.setCustomerId("customer1");
        agreement.setStartDate(LocalDate.now());
        agreement.setEndDate(LocalDate.now().plusDays(10));
        agreement.setPrice(BigDecimal.valueOf(1000));

        MockMultipartFile agreementPart = new MockMultipartFile(
                "agreement", "agreement.json", "application/json",
                ("{\"ownerId\":\"owner1\",\"houseId\":\"house1\",\"customerId\":\"customer1\",\"startDate\":\"2025-06-21\",\"endDate\":\"2025-07-01\",\"price\":1000}").getBytes()
        );
        MockMultipartFile documentPart = new MockMultipartFile(
                "document", "test.pdf", "application/pdf", "dummy content".getBytes()
        );

        mockMvc.perform(multipart("/api/rental-agreements")
                        .file(agreementPart)
                        .file(documentPart)
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk());

        verify(rentalAgreementServiceImpl, times(1)).createRentalAgreement(
                anyString(), anyString(), anyString(), any(LocalDate.class), any(LocalDate.class), any(BigDecimal.class), anyString()
        );
    }

    @Test
    void testGetByOwner() throws Exception {
        RentalAgreement agreement = new RentalAgreement();
        agreement.setOwnerId("owner1");
        OngoingStubbing<com.phenom.flat_mate.entities.RentalAgreement> owner1 = when(rentalAgreementServiceImpl.findByOwnerId("owner1")).thenReturn(agreement);

        mockMvc.perform(get("/api/rental-agreements/owner/owner1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetByHouse() throws Exception {
        when(rentalAgreementServiceImpl.findByHouseId("house1")).thenReturn(List.of());
        mockMvc.perform(get("/api/rental-agreements/house/house1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetByCustomer() throws Exception {
        when(rentalAgreementServiceImpl.findByCustomerId("customer1")).thenReturn(List.of());
        mockMvc.perform(get("/api/rental-agreements/customer/customer1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetByStartDateRange() throws Exception {
        when(rentalAgreementServiceImpl.findByStartDateBetween(any(LocalDate.class), any(LocalDate.class))).thenReturn(List.of());
        mockMvc.perform(get("/api/rental-agreements/start-date?start=2025-06-21&end=2025-07-01"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetByEndDateRange() throws Exception {
        when(rentalAgreementServiceImpl.findByEndDateBetween(any(LocalDate.class), any(LocalDate.class))).thenReturn(List.of());
        mockMvc.perform(get("/api/rental-agreements/end-date?start=2025-06-21&end=2025-07-01"))
                .andExpect(status().isOk());
    }
}

