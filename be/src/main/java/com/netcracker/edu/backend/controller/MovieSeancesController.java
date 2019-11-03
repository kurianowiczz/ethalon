package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.MovieSeance;
import com.netcracker.edu.backend.service.MovieSeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movieSeance")
public class MovieSeancesController {

    private MovieSeanceService movieSeanceService;

    @Autowired
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<MovieSeance> getAllMovieSeances(){
        return movieSeanceService.getAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public MovieSeance saveSeance(@RequestBody MovieSeance movieSeance){
        return movieSeanceService.save(movieSeance);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable(name = "id") Long id){
        movieSeanceService.delete(id);
    }




}
