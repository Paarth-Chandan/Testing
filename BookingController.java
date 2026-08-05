package com.flightreservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.flightreservation.model.User;
import com.flightreservation.service.BookingService;
import com.flightreservation.service.TicketService;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/book")
    public String bookingPage() {

        return "booking/bookingForm";

    }

    @GetMapping("/confirmation")
    public String confirmation() {

        return "booking/bookingConfirmation";

    }

    @GetMapping("/myBookings")
    public String myBookings(HttpSession session,
                             Model model) {

        User user =
                (User) session.getAttribute("loggedInUser");

        model.addAttribute("bookings",
                bookingService.getBookingsByUser(user.getUserId()));

        return "booking/myBookings";

    }

    @GetMapping("/tickets/{bookingId}")
    public String tickets(@PathVariable int bookingId,
                          Model model) {

        model.addAttribute("tickets",
                ticketService.getTicketsByBooking(bookingId));

        return "booking/viewTickets";

    }

}
