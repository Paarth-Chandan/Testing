package com.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.flightreservation.model.Flight;
import com.flightreservation.service.FlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public String searchPage() {

        return "flight/searchFlight";

    }

    @PostMapping("/search")
    public String searchFlight(@RequestParam String source,
                               @RequestParam String destination,
                               Model model) {

        List<Flight> flights =
                flightService.searchFlights(source, destination);

        model.addAttribute("flights", flights);

        return "flight/searchFlight";
    }

}
