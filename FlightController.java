package com.flightreservation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

        return "searchFlight";
    }

    @PostMapping("/search")
    public String searchFlights(@RequestParam String source,
                                @RequestParam String destination,
                                Model model) {

        List<Flight> flights =
                flightService.searchFlights(source, destination);

        model.addAttribute("flights", flights);

        return "searchFlight";
    }

    @GetMapping("/view")
    public String viewFlights(Model model) {

        model.addAttribute("flights",
                flightService.getAllFlights());

        return "viewFlights";
    }

    @GetMapping("/add")
    public String addFlightPage(Model model) {

        model.addAttribute("flight", new Flight());

        return "addFlight";
    }

    @PostMapping("/add")
    public String addFlight(@Valid @ModelAttribute Flight flight,
                            BindingResult result) {

        if(result.hasErrors()) {

            return "addFlight";
        }

        flightService.addFlight(flight);

        return "redirect:/flight/view";
    }

}
