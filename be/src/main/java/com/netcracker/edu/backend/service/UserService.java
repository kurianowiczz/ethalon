package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User findByLogin(String login);
    Optional<User> findById(Long id);
    User update(User user);
    void delete(Long id);
}
