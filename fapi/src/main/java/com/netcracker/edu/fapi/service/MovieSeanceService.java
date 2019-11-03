package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.MovieSeance;

import java.util.List;

public interface MovieSeanceService {
    List<MovieSeance> getAll();
    MovieSeance findByDateTime(String dateTime);
    MovieSeance save(MovieSeance movieSeance);
    void delete(Long id);
}
