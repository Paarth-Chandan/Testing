package com.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.dao.BookingDao;
import com.flightreservation.model.Booking;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public int addBooking(Booking booking) {

        return bookingDao.addBooking(booking);

    }

    @Override
    public List<Booking> getBookingsByUser(int userId) {

        return bookingDao.getBookingsByUser(userId);

    }

    @Override
    public void cancelBooking(int bookingId) {

        bookingDao.cancelBooking(bookingId);

    }

}
