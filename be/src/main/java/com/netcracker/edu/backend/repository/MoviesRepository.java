package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movie, Long> {

}
