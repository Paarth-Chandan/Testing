package com.flightreservation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flightreservation.model.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addFlight(Flight flight) {

        String sql = "INSERT INTO flight(flight_number,source,destination,departure_time,arrival_time,capacity,available_seats,price) VALUES(?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,

                flight.getFlightNumber(),
                flight.getSource(),
                flight.getDestination(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getCapacity(),
                flight.getAvailableSeats(),
                flight.getPrice());

    }

    @Override
    public List<Flight> getAllFlights() {

        String sql = "SELECT * FROM flight";

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Flight.class));

    }

    @Override
    public List<Flight> searchFlights(String source, String destination) {

        String sql = "SELECT * FROM flight WHERE source=? AND destination=?";

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Flight.class),
                source,
                destination);

    }

}
