package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.MovieSeance;

import java.util.List;

public interface MovieSeanceService {
    List<MovieSeance> getAll();
    MovieSeance findByDateTime (String dateTime);
    MovieSeance save(MovieSeance movieSeance);
    void delete(Long id);
}
