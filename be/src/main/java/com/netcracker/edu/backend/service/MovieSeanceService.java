package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.MovieSeance;

import java.util.List;
import java.util.Optional;

public interface MovieSeanceService {
    List<MovieSeance> getSeanceByMovieId(Long movieId);
    MovieSeance findByDateTime (String dateTime);
    MovieSeance save(MovieSeance movieSeance);
    void delete(Long id);
    Optional<MovieSeance> getSeanceById(Long id);
}
