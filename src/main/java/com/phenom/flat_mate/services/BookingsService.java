package com.phenom.flat_mate.services;

import com.phenom.flat_mate.entities.Bookings;
import java.util.List;

public interface BookingsService {
    Bookings createBooking(Bookings booking);
    Bookings getBookingById(Long id);
    void deleteBooking(Long id);
}