package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.entity.Seance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeanceRepository extends CrudRepository<Seance, Long> {
    Optional<Seance> findById(Long id);
    //TODO
//    @Query("select movie from Seance where movieid = :id")
//    Movie getMovieBySeanceId(@Param("id") Long id);
}
