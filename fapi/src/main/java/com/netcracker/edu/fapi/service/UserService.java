package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByLogin(String userName);
    User findById(Long id);
    User update(User user);
    void delete(Long id);
}
