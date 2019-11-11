package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.MovieSeance;
import com.netcracker.edu.fapi.service.MovieSeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movieSeances")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieSeancesController {

    @Autowired
    private MovieSeanceService movieSeanceService;

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
////    public ResponseEntity<List<MovieSeance>> getAllMovieSeances(){
////
////        return ResponseEntity.ok(movieSeanceService.getAll());
////    }
//    public List<MovieSeance> getAllSeances() {
//
//        return movieSeanceService.getAll();
//    }

    @RequestMapping(value = "/all/{movieId}", method = RequestMethod.GET)
    public List<MovieSeance> getSeanceByMovieId(@PathVariable(name = "movieId") Long movieId){
        return movieSeanceService.getSeanceByMovieId(movieId);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<MovieSeance> getSeanceById(@PathVariable(name = "id") long id) {
        MovieSeance seance = movieSeanceService.findById(id);
        return seance != null ? ResponseEntity.ok(seance) : ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MovieSeance> updateSeance(@RequestBody MovieSeance movieSeance) {
        if (movieSeance != null) {
            return ResponseEntity.ok(movieSeanceService.save(movieSeance));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSeance(@PathVariable Long id){
        movieSeanceService.delete(Long.valueOf(id));
    }


}
