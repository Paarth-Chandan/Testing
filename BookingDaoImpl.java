package com.flightreservation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flightreservation.model.Booking;

@Repository
public class BookingDaoImpl implements BookingDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBooking(Booking booking) {

        String sql = "INSERT INTO booking(booking_date,journey_date,seats,total_price,status,user_id,flight_id) VALUES(?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,

                booking.getBookingDate(),
                booking.getJourneyDate(),
                booking.getSeats(),
                booking.getTotalPrice(),
                booking.getStatus(),
                booking.getUserId(),
                booking.getFlightId());

    }

    @Override
    public List<Booking> getBookingsByUser(int userId) {

        String sql = "SELECT * FROM booking WHERE user_id=?";

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Booking.class),
                userId);

    }

    @Override
    public void cancelBooking(int bookingId) {

        String sql = "UPDATE booking SET status='Cancelled' WHERE booking_id=?";

        jdbcTemplate.update(sql, bookingId);

    }

}
