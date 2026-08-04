package com.flightreservation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flightreservation.model.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addTicket(Ticket ticket) {

        String sql = "INSERT INTO ticket(passenger_name,gender,age,seat_number,pnr,booking_id) VALUES(?,?,?,?,?,?)";

        jdbcTemplate.update(sql,

                ticket.getPassengerName(),
                ticket.getGender(),
                ticket.getAge(),
                ticket.getSeatNumber(),
                ticket.getPnr(),
                ticket.getBookingId());

    }

    @Override
    public List<Ticket> getTicketsByBooking(int bookingId) {

        String sql = "SELECT * FROM ticket WHERE booking_id=?";

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Ticket.class),
                bookingId);

    }

}
