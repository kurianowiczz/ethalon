package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Tickets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sun.security.krb5.internal.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Tickets, Long> {
}
