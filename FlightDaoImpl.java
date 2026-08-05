package com.flightreservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.flightreservation.model.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Flight> rowMapper = new RowMapper<Flight>() {

        @Override
        public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {

            Flight flight = new Flight();

            flight.setFlightId(rs.getInt("flight_id"));
            flight.setFlightNumber(rs.getString("flight_number"));
            flight.setSource(rs.getString("source"));
            flight.setDestination(rs.getString("destination"));
            flight.setDepartureTime(rs.getString("departure_time"));
            flight.setArrivalTime(rs.getString("arrival_time"));
            flight.setCapacity(rs.getInt("capacity"));
            flight.setAvailableSeats(rs.getInt("available_seats"));
            flight.setPrice(rs.getDouble("price"));

            return flight;
        }

    };

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

        return jdbcTemplate.query(sql, rowMapper);

    }

    @Override
    public List<Flight> searchFlights(String source, String destination) {

        String sql = "SELECT * FROM flight WHERE source=? AND destination=?";

        return jdbcTemplate.query(sql, rowMapper, source, destination);

    }

    @Override
    public Flight getFlightById(int flightId) {

        String sql = "SELECT * FROM flight WHERE flight_id=?";

        return jdbcTemplate.queryForObject(sql, rowMapper, flightId);

    }

    @Override
    public void updateFlight(Flight flight) {

        String sql = "UPDATE flight SET flight_number=?, source=?, destination=?, departure_time=?, arrival_time=?, capacity=?, available_seats=?, price=? WHERE flight_id=?";

        jdbcTemplate.update(sql,

                flight.getFlightNumber(),
                flight.getSource(),
                flight.getDestination(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getCapacity(),
                flight.getAvailableSeats(),
                flight.getPrice(),
                flight.getFlightId());

    }

    @Override
    public void deleteFlight(int flightId) {

        String sql = "DELETE FROM flight WHERE flight_id=?";

        jdbcTemplate.update(sql, flightId);

    }

}
