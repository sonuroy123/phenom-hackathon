
package com.phenom.flat_mate.servicelmpl;

import com.phenom.flat_mate.entities.Bookings;
import com.phenom.flat_mate.repository.BookingsRepository;
import com.phenom.flat_mate.services.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsServiceImpl implements BookingsService {

    @Autowired
    private BookingsRepository bookingsRepository;

    @Override
    public Bookings createBooking(Bookings booking) {
        return bookingsRepository.save(booking);
    }

    @Override
    public Bookings getBookingById(Long id) {
        return bookingsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
    }



    @Override
    public void deleteBooking(Long id) {
        bookingsRepository.deleteById(id);
    }
}
