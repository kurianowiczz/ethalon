package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovieById(@PathVariable(name = "id") Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public Movie deleteMovie(@PathVariable(name = "id") Long id) {
        return movieService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.update(movie);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST) //?
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }


}
