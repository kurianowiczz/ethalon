package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {
    @Autowired
    private MovieService service;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List getAllMovies() {
        return service.getAllMovies();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@PathVariable(name = "id") Long id) {
        Optional<Movie> movie = service.getMovieById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public Movie deleteMovie(@PathVariable(name = "id") Long id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Movie updateMovie(@RequestBody Movie movie) {
        return service.update(movie);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Movie addMovie(@RequestBody Movie movie) {

        return service.addMovie(movie);
    }

}
