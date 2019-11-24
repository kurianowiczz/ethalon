package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Seance;
import com.netcracker.edu.fapi.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/seances")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SeancesController {

    @Autowired
    private SeanceService seanceService;

    @RequestMapping(value = "/all/seance/{movieId}", method = RequestMethod.GET)
    public List<Seance> getSeanceByMovieId(@PathVariable(name = "movieId") Long movieId){
        return seanceService.getSeanceByMovieId(movieId);
    }

    @RequestMapping(value = "/all/movie/{seanceId}", method = RequestMethod.GET)
    public List<Seance> getMovieBySeanceId(@PathVariable(name = "seanceId") Long seanceId){
        return seanceService.getMovieBySeanceId(seanceId);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Seance> getSeanceById(@PathVariable(name = "id") long id) {
        Seance seance = seanceService.findById(id);
        return seance != null ? ResponseEntity.ok(seance) : ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Seance> updateSeance(@RequestBody Seance movieSeance) {
        if (movieSeance != null) {
            return ResponseEntity.ok(seanceService.save(movieSeance));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSeance(@PathVariable Long id){
        seanceService.delete(Long.valueOf(id));
    }


}
