package com.flightreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @GetMapping("/book")
    public String bookingPage() {

        return "bookingForm";

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
