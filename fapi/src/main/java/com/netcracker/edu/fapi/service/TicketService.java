package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Ticket;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAll();
    void delete(Long id);
    Ticket findById(long id);
    List<Ticket> getTicketsForSeance(Long seanceId);
    List<Ticket> save(List<Ticket> tickets);

}
