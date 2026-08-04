package com.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.dao.FlightDao;
import com.flightreservation.model.Flight;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightDao flightDao;

    @Override
    public void addFlight(Flight flight) {

        flightDao.addFlight(flight);

    }

    @Override
    public List<Flight> getAllFlights() {

        return flightDao.getAllFlights();

    }

    @Override
    public List<Flight> searchFlights(String source, String destination) {

        return flightDao.searchFlights(source, destination);

    }

}
