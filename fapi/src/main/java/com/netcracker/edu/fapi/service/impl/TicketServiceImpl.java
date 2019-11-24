package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Ticket;
import com.netcracker.edu.fapi.service.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("ticket")
public class TicketServiceImpl implements TicketService {

    @Value("${backend.server.url}")
    private String BACKEND_SERVER_URL;

    @Override
    public List<Ticket> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketsResponce = restTemplate.getForObject(BACKEND_SERVER_URL + "api/tickets/all", Ticket[].class);
        return ticketsResponce == null ? Collections.emptyList() : Arrays.asList(ticketsResponce);
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
        Ticket[] ticketsResponse = restTemplate.getForObject(
          BACKEND_SERVER_URL + "api/tickets/all/" + seanceId, Ticket[].class);
        return ticketsResponse == null ? Collections.emptyList() : Arrays.asList(ticketsResponse);

    }

//    @Override
//    public List<Ticket> save(List<Ticket> tickets) {
//        RestTemplate restTemplate = new RestTemplate();
//        Ticket[] ticketsResponse = restTemplate.getForObject(
//                BACKEND_SERVER_URL + "api/tickets" + tickets, Ticket[].class);
//        return ticketsResponse == null ? Collections.emptyList() : Arrays.asList(ticketsResponse);
//    }

    @Override
    public List<Ticket> save(List<Ticket> tickets) {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketsResponse = restTemplate.postForEntity(
                BACKEND_SERVER_URL + "/api/tickets", tickets, Ticket[].class).getBody();
        return ticketsResponse == null ? Collections.emptyList() : Arrays.asList(ticketsResponse);
    }
}
