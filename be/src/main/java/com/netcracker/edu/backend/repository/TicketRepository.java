package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Seance;
import com.netcracker.edu.backend.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findAll();
    List<Ticket> findByMovieSeance(Seance movieSeance);

}