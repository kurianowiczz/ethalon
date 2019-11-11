package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.MovieSeance;
import com.netcracker.edu.backend.service.MovieSeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movieSeances")
public class MovieSeancesController {

    @Autowired
    private MovieSeanceService movieSeanceService;

    @RequestMapping(value = "/all/{movieId}", method = RequestMethod.GET)
    public List<MovieSeance> getAllMovieSeances(@PathVariable(name = "movieId") Long movieId){
        return movieSeanceService.getSeanceByMovieId(movieId);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieSeance> getSeanceById(@PathVariable(name = "id") Long id) {
        Optional<MovieSeance> seance = movieSeanceService.getSeanceById(id);
        if (seance.isPresent()) {
            return ResponseEntity.ok(seance.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public MovieSeance saveSeance(@RequestBody MovieSeance movieSeance){

        return movieSeanceService.save(movieSeance);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable(name = "id") Long id){

        movieSeanceService.delete(id);
    }




}
