package com.flightreservation.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.flightreservation.model.Booking;

@Repository
public class BookingDaoImpl implements BookingDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addBooking(Booking booking) {

        String sql = "INSERT INTO booking(booking_date,journey_date,seats,total_price,status,user_id,flight_id) VALUES(?,?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, booking.getBookingDate());
            ps.setString(2, booking.getJourneyDate());
            ps.setInt(3, booking.getSeats());
            ps.setDouble(4, booking.getTotalPrice());
            ps.setString(5, booking.getStatus());
            ps.setInt(6, booking.getUserId());
            ps.setInt(7, booking.getFlightId());

            return ps;

        }, keyHolder);

        return keyHolder.getKey().intValue();

    }

    @Override
    public List<Booking> getBookingsByUser(int userId) {

        String sql = "SELECT * FROM booking WHERE user_id=?";

        return jdbcTemplate.query(sql,

                (rs, rowNum) -> {

                    Booking booking = new Booking();

                    booking.setBookingId(rs.getInt("booking_id"));
                    booking.setBookingDate(rs.getString("booking_date"));
                    booking.setJourneyDate(rs.getString("journey_date"));
                    booking.setSeats(rs.getInt("seats"));
                    booking.setTotalPrice(rs.getDouble("total_price"));
                    booking.setStatus(rs.getString("status"));
                    booking.setUserId(rs.getInt("user_id"));
                    booking.setFlightId(rs.getInt("flight_id"));

                    return booking;

                },

                userId);

    }

    @Override
    public void cancelBooking(int bookingId) {

        String sql = "UPDATE booking SET status='Cancelled' WHERE booking_id=?";

        jdbcTemplate.update(sql, bookingId);

    }

}
