package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.MovieSeance;
import com.netcracker.edu.fapi.service.MovieSeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movieSeance/")
public class MovieSeancesController {

    @Autowired
    private MovieSeanceService movieSeanceService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<MovieSeance>> getAllMovieSeances(){

        return ResponseEntity.ok(movieSeanceService.getAll());
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
