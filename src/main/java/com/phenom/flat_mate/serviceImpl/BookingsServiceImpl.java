package com.phenom.flat_mate.serviceImpl;

import com.phenom.flat_mate.entities.Booking;
import com.phenom.flat_mate.repository.BookingRepository;
import com.phenom.flat_mate.services.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsServiceImpl implements BookingsService {

    @Autowired
    private BookingRepository bookingsRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingsRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
    }



    @Override
    public void deleteBooking(Long id) {
        bookingsRepository.deleteById(id);
    }
}
