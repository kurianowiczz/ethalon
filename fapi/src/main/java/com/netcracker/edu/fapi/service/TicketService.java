package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAll();
    Ticket update(Ticket ticket);
    void delete(Long id);
    Ticket findById(long id);
    List<Ticket> getTicketsForSeance(Long seanceId);
}
