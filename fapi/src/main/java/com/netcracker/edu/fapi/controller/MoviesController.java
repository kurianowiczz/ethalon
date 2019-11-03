package com.netcracker.edu.fapi.controller;

<<<<<<< HEAD
import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.MovieServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/all")
public class MoviesController {

    @Autowired
    private MovieServise movieServise;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieServise.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable Long id){
        movieServise.delete(Long.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        if (movie != null) {
            return ResponseEntity.ok(movieServise.save(movie));
        }
        return null;
    }
=======
public class MoviesController {
>>>>>>> 1d503208be752fba7dd47b42b8582f9cc7e58c73
}
