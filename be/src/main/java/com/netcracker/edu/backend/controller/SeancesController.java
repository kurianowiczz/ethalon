package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.entity.Seance;
import com.netcracker.edu.backend.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seances")
public class SeancesController {

    @Autowired
    private SeanceService seanceService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Seance>> getAllSeances(){
        List<Seance> seances = seanceService.findAll();
        return ResponseEntity.ok(seances);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Seance> getSeanceById(@PathVariable(name = "id") Long id){
        Seance seance = seanceService.findById(id);
        return ResponseEntity.ok(seance);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Seance saveSeance(@RequestBody Seance seance){

        return seanceService.save(seance);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable(name = "id") Long id){

        seanceService.delete(id);
    }

//    @RequestMapping(value = "all/movie/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Movie> getMovieBySeanceId(@PathVariable(name="id") Long id){
//        Movie movie = seanceService.getMovieBySeanceId(id);
//        return ResponseEntity.ok(movie);
//    }

    //getSeanceByMovieId(Long movieId)

}
