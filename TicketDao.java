package com.flightreservation.dao;

import java.util.List;

import com.flightreservation.model.Ticket;

public interface TicketDao {

    void addTicket(Ticket ticket);

    List<Ticket> getTicketsByBooking(int bookingId);

}
