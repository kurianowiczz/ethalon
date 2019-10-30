package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie addMovie(Movie newMovie);
    Movie delete(long id);
    Movie update(Movie movie);
    Optional<Movie> getMovieById(Long id);
}
