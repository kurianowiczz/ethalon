package com.netcracker.edu.backend.repository;

import org.springframework.data.repository.CrudRepository;
import sun.security.krb5.internal.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
