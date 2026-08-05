package com.flightreservation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.flightreservation.model.Flight;
import com.flightreservation.service.FlightService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/adminDashboard";
    }

    @GetMapping("/addFlight")
    public String addFlightPage(Model model) {

        model.addAttribute("flight", new Flight());

        return "admin/addFlight";
    }

    @PostMapping("/addFlight")
    public String addFlight(@Valid @ModelAttribute("flight") Flight flight,
                            BindingResult result) {

        if(result.hasErrors()) {
            return "admin/addFlight";
        }

        flightService.addFlight(flight);

        return "redirect:/admin/viewFlights";
    }

    @GetMapping("/viewFlights")
    public String viewFlights(Model model) {

        model.addAttribute("flights", flightService.getAllFlights());

        return "admin/viewFlights";
    }

    @GetMapping("/editFlight/{id}")
    public String editFlight(@PathVariable("id") int id,
                             Model model) {

        model.addAttribute("flight",
                flightService.getFlightById(id));

        return "admin/editFlight";
    }

    @PostMapping("/updateFlight")
    public String updateFlight(@ModelAttribute Flight flight) {

        flightService.updateFlight(flight);

        return "redirect:/admin/viewFlights";
    }

    @GetMapping("/deleteFlight/{id}")
    public String deleteFlight(@PathVariable("id") int id) {

        flightService.deleteFlight(id);

        return "redirect:/admin/viewFlights";
    }

}
