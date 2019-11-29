package com.netcracker.edu.backend.converter.impl;

import com.netcracker.edu.backend.converter.TicketConverter;
import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.viewmodel.TicketViewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverterImpl implements TicketConverter {
    @Override
    public List<TicketViewModel> convert(List<Ticket> tickets) {
        List<TicketViewModel> ticketViewModels = new ArrayList<>();
        tickets.forEach(ticket -> {
            TicketViewModel ticketViewModel = new TicketViewModel();
            ticketViewModel.setId(ticket.getId());
            ticketViewModel.setLine(ticket.getLine());
            ticketViewModel.setSeanceid(ticket.getMovieSeance().getId().intValue());
            ticketViewModel.setUserid(ticket.getUserid().getId().intValue());
            ticketViewModel.setSeat(ticket.getSeat());
            ticketViewModels.add(ticketViewModel);
        });
        return ticketViewModels;
    }
}
