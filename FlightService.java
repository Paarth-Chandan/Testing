package com.flightreservation.service;

import java.util.List;

import com.flightreservation.model.Flight;

public interface FlightService {

    void addFlight(Flight flight);

    List<Flight> getAllFlights();

    List<Flight> searchFlights(String source, String destination);

}
