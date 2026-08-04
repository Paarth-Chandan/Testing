package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book")
    public String bookingPage(@RequestParam int flightId,
                              Model model) {

        model.addAttribute("flightId", flightId);

        return "bookingForm";
    }

    @PostMapping("/confirmBooking")
    public String confirmBooking(@RequestParam int flightId,
                                 @RequestParam int userId,
                                 @RequestParam int seats) {

        bookingService.bookFlight(userId, flightId, seats);

        return "bookingConfirmation";
    }

    @GetMapping("/confirmation")
    public String confirmation() {

        return "bookingConfirmation";
    }

    @GetMapping("/myBookings")
    public String myBookings() {

        return "myBookings";
    }

    @GetMapping("/tickets")
    public String tickets() {

        return "viewTickets";
    }

}
