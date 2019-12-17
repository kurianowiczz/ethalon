package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByLogin(String userName);
    User findByPassword(String password);
    User findById(Long id);
    User addUser(User newUser);
    User getUserByUserNameAndPassword(String userName, String password);
    void delete(Long id);
}
