package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Ticket;
import com.netcracker.edu.fapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Ticket> getAllTickets(){
        return ticketService.getAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.update(ticket);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTicketById(@PathVariable(name = "id") long id) {
        ticketService.delete(id);
    }

}
