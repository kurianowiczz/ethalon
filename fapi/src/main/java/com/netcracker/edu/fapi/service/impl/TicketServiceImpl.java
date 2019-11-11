package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Ticket;
import com.netcracker.edu.fapi.service.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("ticket")
public class TicketServiceImpl implements TicketService {

    @Value("${backend.server.url}")
    private String BACKEND_SERVER_URL;

    @Override
    public List<Ticket> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketsResponce = restTemplate.getForObject(BACKEND_SERVER_URL + "/api/tickets/all", Ticket[].class);
        return ticketsResponce == null ? Collections.emptyList() : Arrays.asList(ticketsResponce);
    }

    @Override
    public Ticket update(Ticket ticket) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(BACKEND_SERVER_URL + "/api/tickets/", ticket, Ticket.class).getBody();

    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BACKEND_SERVER_URL + "api/tickets/" + id);
    }

    @Override
    public Ticket findById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BACKEND_SERVER_URL + "api/tickets/id/" + id, Ticket.class);
    }

    @Override
    public List<Ticket> getTicketsForSeance(Long seanceId) {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketsResponce = restTemplate.getForObject(
          BACKEND_SERVER_URL + "/api/tickets/all/" + seanceId, Ticket[].class);
        return ticketsResponce == null ? Collections.emptyList() : Arrays.asList(ticketsResponce);
    }
}
