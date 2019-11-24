package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Seance;
import com.netcracker.edu.backend.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTicket();
    List<Ticket> findByMovieSeance(Seance movieSeance);
    Optional<Ticket> findById(long id);
    List<Ticket> save(List<Ticket> tickets);
    void delete(Long id);
}