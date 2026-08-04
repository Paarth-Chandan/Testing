package com.flightreservation.dao;

import java.util.List;

import com.flightreservation.model.Booking;

public interface BookingDao {

    void addBooking(Booking booking);

    List<Booking> getBookingsByUser(int userId);

    void cancelBooking(int bookingId);

}
