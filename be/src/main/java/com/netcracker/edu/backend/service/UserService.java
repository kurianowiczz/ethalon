package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User update(User user);
    void delete(Long id);
    Optional<User> findById(Long id);
    User findByUsername(String userName);
//    List<Ticket> getTicketByUserId(Long id);
//    List<Ticket> getTicketByUsername(String userName);
    User addUser(User user);
}