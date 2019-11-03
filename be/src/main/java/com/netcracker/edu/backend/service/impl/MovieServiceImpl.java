package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.repository.MoviesRepository;
import com.netcracker.edu.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) moviesRepository.findAll();
    }

    @Override
    public Movie addMovie(Movie newMovie) {
        return moviesRepository.save(newMovie);
    }

    @Override
    public Movie delete(long id) {
        moviesRepository.deleteById(id);
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        moviesRepository.save(movie);
        return movie;
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {

        return moviesRepository.findById(id);
    }
}