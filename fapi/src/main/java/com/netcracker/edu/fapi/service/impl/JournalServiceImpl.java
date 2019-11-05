package com.netcracker.edu.fapi.service.impl;


import com.netcracker.edu.fapi.models.Journal;
import com.netcracker.edu.fapi.service.JournalService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("journalService")
public class JournalServiceImpl implements JournalService {

    @Value("http://localhost:8080/")
    private static String BACKEND_SERVER_URL;

    @Override
    public List<Journal> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Journal[] journalsResponse = restTemplate.getForObject(BACKEND_SERVER_URL + "/api/journal/all", Journal[].class);
        return journalsResponse == null ? Collections.emptyList() : Arrays.asList(journalsResponse);

    }

    @Override
    public Journal update(Journal journal) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(BACKEND_SERVER_URL + "/api/journal/", journal, Journal.class).getBody();
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BACKEND_SERVER_URL + "api/journal/" + id);
    }

    @Override
    public Journal getByUserId(Long userId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BACKEND_SERVER_URL + "api/journal/userId/" + userId, Journal.class);
    }

}
