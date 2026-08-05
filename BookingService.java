package com.flightreservation.service;

import java.util.List;

import com.flightreservation.model.Booking;

public interface BookingService {

    int addBooking(Booking booking);

    List<Booking> getBookingsByUser(int userId);

    void cancelBooking(int bookingId);

}
