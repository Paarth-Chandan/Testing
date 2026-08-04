package com.flightreservation.service;

import java.util.List;

import com.flightreservation.model.Ticket;

public interface TicketService {

    void addTicket(Ticket ticket);

    List<Ticket> getTicketsByBooking(int bookingId);

}
