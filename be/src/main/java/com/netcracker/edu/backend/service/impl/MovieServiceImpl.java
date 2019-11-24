package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.repository.MovieRepository;
import com.netcracker.edu.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Movie addMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @Override
    public Movie delete(long id) {
        movieRepository.deleteById(id);
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findMovieById(id);
    }
}
