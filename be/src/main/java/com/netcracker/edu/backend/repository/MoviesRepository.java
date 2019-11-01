package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<Movie, Long> {

}
