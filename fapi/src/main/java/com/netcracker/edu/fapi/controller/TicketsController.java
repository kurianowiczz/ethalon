package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Ticket;
import com.netcracker.edu.fapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketsController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Ticket> getAll(){
        return ticketService.getAll();
    }

    @RequestMapping(value = "/all/{seanceId}", method = RequestMethod.GET)
    public List<Ticket> getTicketsForSeance(@PathVariable(name = "seanceId") Long seanceId){
        return ticketService.getTicketsForSeance(seanceId);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteTicketById(@PathVariable(name = "id") long id) {

        ticketService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST) //buy tickets
    public List<Ticket> saveTicket(@RequestBody List<Ticket> tickets){
        return ticketService.save(tickets);
    }


}
