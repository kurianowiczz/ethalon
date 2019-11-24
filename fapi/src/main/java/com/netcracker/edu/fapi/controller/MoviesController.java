package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Movie> getAllMovies(){
        return movieService.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@PathVariable(name = "id") long id) {
        Movie movie = movieService.findById(id);
        return movie != null ? ResponseEntity.ok(movie) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable Long id){
        movieService.delete(Long.valueOf(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        if (movie != null) {
            return ResponseEntity.ok(movieService.save(movie));
        }
        return null;
    }
}

