package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.entity.Seance;

import java.util.List;

public interface SeanceService {
    List<Seance> findAll();
    Seance findById(Long id);
    Seance save(Seance movieSeance);
    void delete(Long id);
    //Movie getMovieBySeanceId(Long id);
    //Movie getSeanceByMovieId(Long id);
}
