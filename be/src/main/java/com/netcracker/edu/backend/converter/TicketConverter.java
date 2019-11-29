package com.netcracker.edu.backend.converter;

import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.viewmodel.TicketViewModel;

import java.util.List;

public interface TicketConverter {
    List<TicketViewModel> convert (List<Ticket> tickets);
}
