package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Seance;
import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.repository.SeanceRepository;
import com.netcracker.edu.backend.repository.TicketRepository;
import com.netcracker.edu.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SeanceRepository seanceRepository;


    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findByMovieSeance(Seance movieSeance) {
        return ticketRepository.findByMovieSeance(movieSeance);
    }

    @Override
    public Optional<Ticket> findById(long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> save(List<Ticket> tickets) {
        for(Ticket ticket : tickets) {
            ticketRepository.save(ticket);
        }
        return tickets;
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}
