package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketsController {
    private TicketService ticketService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Ticket> getAllTicket(){
        return ticketService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ticket saveTicket(@RequestBody Ticket ticket){
        return ticketService.save(ticket);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable(name = "id") Long id){
        ticketService.delete(id);
    }

}
