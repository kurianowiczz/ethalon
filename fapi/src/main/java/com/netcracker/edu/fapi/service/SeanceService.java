package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Seance;

import java.util.List;

public interface SeanceService {
    List<Seance> getAll();
    Seance findById(Long id);
    List<Seance> getSeanceByMovieId(Long movieId);
    List<Seance> getMovieBySeanceId(Long seanceId);
    Seance findByDateTime(String dateTime);
    Seance save(Seance movieSeance);
    void delete(Long id);
}
