package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.MovieSeance;
import org.springframework.data.repository.CrudRepository;

public interface MovieSeanceRepository extends CrudRepository<MovieSeance, Long> {
    MovieSeance findByDateTime(String dateTime);
}
