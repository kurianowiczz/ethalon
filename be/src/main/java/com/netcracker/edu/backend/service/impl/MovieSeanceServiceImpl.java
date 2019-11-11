package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.MovieSeance;
import com.netcracker.edu.backend.repository.MovieSeanceRepository;
import com.netcracker.edu.backend.service.MovieSeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSeanceServiceImpl implements MovieSeanceService {
    @Autowired
    private MovieSeanceRepository movieSeanceRepository;


    @Override
    public List<MovieSeance> getSeanceByMovieId(Long movieId) {
        return (List<MovieSeance>) movieSeanceRepository.getSeanceByMovieId(movieId);
    }

    @Override
    public MovieSeance findByDateTime(String dateTime) {

        return movieSeanceRepository.findByDateTime(dateTime);
    }

    @Override
    public MovieSeance save(MovieSeance movieSeance) {
        return movieSeanceRepository.save(movieSeance);
    }

    @Override
    public void delete(Long id) {
        movieSeanceRepository.deleteById(id);
    }

    @Override
    public Optional<MovieSeance> getSeanceById(Long id) {
        return movieSeanceRepository.findById(id);
    }
}
