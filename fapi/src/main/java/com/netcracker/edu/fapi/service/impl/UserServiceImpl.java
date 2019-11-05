package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Value("http://localhost:8080/")
    private String BACKEND_SERVER_URL;

    @Override
    public List<User> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(BACKEND_SERVER_URL + "/api/user", User[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public User findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(BACKEND_SERVER_URL + "/api/user/login/" + login, User.class);
        return user;
    }

    @Override
    public User findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BACKEND_SERVER_URL + "/api/user/" + id, User.class);
    }

    @Override
    public User update(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(BACKEND_SERVER_URL + "/api/user/", user, User.class).getBody();
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BACKEND_SERVER_URL + "api/user/" + id);
    }
}
