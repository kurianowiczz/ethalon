package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie addMovie(Movie newMovie);
    Movie delete(long id);
    Movie update(Movie movie);
    Movie getMovieById(Long id);
}
