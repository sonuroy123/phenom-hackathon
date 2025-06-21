package com.phenom.flat_mate.services;
import com.phenom.flat_mate.repository.BookingRepository;
import com.phenom.flat_mate.entities.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingsService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long id);
    void deleteBooking(Long id);
}