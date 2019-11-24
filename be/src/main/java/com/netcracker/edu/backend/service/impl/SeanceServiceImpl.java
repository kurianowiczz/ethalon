package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Seance;
import com.netcracker.edu.backend.repository.SeanceRepository;
import com.netcracker.edu.backend.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceServiceImpl implements SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;


    @Override
    public List<Seance> findAll() {
        return ( List<Seance> )seanceRepository.findAll();
    }

    @Override
    public Seance findById(Long id) {
        return seanceRepository.findById(id).get();
    }

    @Override
    public Seance save(Seance seance) {
        return seanceRepository.save(seance);
    }

    @Override
    public void delete(Long id) {
        seanceRepository.deleteById(id);
    }

//    @Override
//    public Movie getMovieBySeanceId(Long id) {
//        return seanceRepository.getMovieBySeanceId(id);
//    }
}
