package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAll();
    Ticket save(Ticket ticket);
    void delete(Long id);
}
