package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.MovieSeance;
import com.netcracker.edu.fapi.service.MovieSeanceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("movieSeanceService")
public class MovieSeanceServiceImpl implements MovieSeanceService {

    @Value("${backend.server.url}")
    private static String BACKEND_SERVER_URL;

    @Override
    public List<MovieSeance> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        MovieSeance[] movieSeancesResponse = restTemplate.getForObject(BACKEND_SERVER_URL + "/api/movieSeances/all ", MovieSeance[].class);
        return movieSeancesResponse == null ? Collections.emptyList() : Arrays.asList(movieSeancesResponse);

    }

    @Override
    public MovieSeance findByDateTime(String dateTime) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BACKEND_SERVER_URL + "/api/movieSeances/" + dateTime, MovieSeance.class);
    }

    @Override
    public MovieSeance save(MovieSeance movieSeance) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(BACKEND_SERVER_URL + "/api/movieSeances/", movieSeance, MovieSeance.class).getBody();

    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BACKEND_SERVER_URL + "/api/movieSeances/" + id);

    }
}
