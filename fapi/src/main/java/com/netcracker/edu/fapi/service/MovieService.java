package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    void delete(Long id);
    Movie save(Movie movie);
}