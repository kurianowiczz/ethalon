package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Seance;
import com.netcracker.edu.fapi.service.SeanceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("movieSeanceService")
public class SeanceServiceImpl implements SeanceService {

    @Value("${backend.server.url}")
    private String BACKEND_SERVER_URL;

    @Override
    public List<Seance> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Seance[] seancesResponse = restTemplate.getForObject(BACKEND_SERVER_URL + "/api/seances/all/", Seance[].class);
        return seancesResponse == null ? Collections.emptyList() : Arrays.asList(seancesResponse);
    }

    @Override
    public Seance findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BACKEND_SERVER_URL + "api/seances/id/" + id, Seance.class);
    }

    @Override
    public List<Seance> getSeanceByMovieId(Long movieId) {
        RestTemplate restTemplate = new RestTemplate();
        Seance[] seancesResponse = restTemplate.getForObject(
                BACKEND_SERVER_URL + "/api/seances/all/seance" + movieId, Seance[].class);
        return seancesResponse == null ? Collections.emptyList() : Arrays.asList(seancesResponse);
    }

    @Override
    public List<Seance> getMovieBySeanceId(Long seanceId) {
        RestTemplate restTemplate = new RestTemplate();
        Seance[] seancesResponse = restTemplate.getForObject(
                BACKEND_SERVER_URL + "/api/seances/all/movie" + seanceId, Seance[].class);
        return seancesResponse == null ? Collections.emptyList() : Arrays.asList(seancesResponse);
    }

    @Override
    public Seance findByDateTime(String dateTime) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BACKEND_SERVER_URL + "/api/seances/dateTime" + dateTime, Seance.class);
    }

    @Override
    public Seance save(Seance movieSeance) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(BACKEND_SERVER_URL + "/api/seances/", movieSeance, Seance.class).getBody();

    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BACKEND_SERVER_URL + "/api/seances/" + id);

    }
}
