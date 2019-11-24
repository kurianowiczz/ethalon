package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Seance;
import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.service.SeanceService;
import com.netcracker.edu.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeanceService seanceService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTicket();
    }

    @RequestMapping(value = "/all/{seanceId}", method = RequestMethod.GET)
    public List<Ticket> getAllTicketForSeance(@PathVariable(name = "seanceId") Long seanceId){
        Seance movieSeance = seanceService.findById(seanceId);
        List<Ticket> tickets = ticketService.findByMovieSeance(movieSeance);
        return tickets;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ticket> getTicketById(@PathVariable(name = "id") Long id) {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket.isPresent()) {
            return ResponseEntity.ok(ticket.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST) //buy tickets
    public List<Ticket> saveTicket(@RequestBody List<Ticket> tickets){
        return ticketService.save(tickets);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable(name = "id") Long id){
        ticketService.delete(id);
    }
}
