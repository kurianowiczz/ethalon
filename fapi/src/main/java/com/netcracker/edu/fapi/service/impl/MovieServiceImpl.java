package com.netcracker.edu.fapi.service.impl;

<<<<<<< HEAD
import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.MovieServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieServise {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Movie> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Movie[] moviesResponse = restTemplate.getForObject(backendServerUrl + "/movies/all ", Movie[].class);
        return moviesResponse == null ? Collections.emptyList() : Arrays.asList(moviesResponse);

    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "movies/all" + id);
    }

    @Override
    public Movie save(Movie movie) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "all/movies/", movie, Movie.class).getBody();
    }

=======
public class MovieService {
>>>>>>> 1d503208be752fba7dd47b42b8582f9cc7e58c73
}
