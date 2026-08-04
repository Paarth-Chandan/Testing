package com.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.dao.TicketDao;
import com.flightreservation.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Override
    public void addTicket(Ticket ticket) {

        ticketDao.addTicket(ticket);

    }

    @Override
    public List<Ticket> getTicketsByBooking(int bookingId) {

        return ticketDao.getTicketsByBooking(bookingId);

    }

}
