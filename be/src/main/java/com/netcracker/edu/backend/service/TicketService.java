package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAll();
    Ticket save(Ticket ticket);
    void delete(Long id);
    Optional<Ticket> findById(long id);
    List<Ticket> getTicketsForSeance(Long seanceId);
}
