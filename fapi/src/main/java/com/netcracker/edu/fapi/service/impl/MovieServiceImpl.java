package com.netcracker.edu.fapi.service.impl;
import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Value("${backend.server.url}")
    private String BACKEND_SERVER_URL;

    @Override
    public List<Movie> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Movie[] moviesResponse = restTemplate.getForObject(BACKEND_SERVER_URL + "api/movies/all ", Movie[].class);
        return moviesResponse == null ? Collections.emptyList() : Arrays.asList(moviesResponse);

    }

    @Override
    public Movie findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BACKEND_SERVER_URL + "api/movies/id/" + id, Movie.class);
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BACKEND_SERVER_URL + "api/movies/id/" + id);
    }

    @Override
    public Movie save(Movie movie) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(BACKEND_SERVER_URL + "api/movies/add", movie, Movie.class).getBody();
    }

}