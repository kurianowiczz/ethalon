package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {

        return userService.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id) {
        Optional<User> user = userService.findById(id);
        return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/login/{userName}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUserName(@PathVariable(name = "userName") String userName) {
        User user = userService.findByUsername(userName);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }

//    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
//    public ResponseEntity<List<Ticket>> getTicketByUserId(@PathVariable(name = "id") Long id){
//        List<Ticket> ticket = userService.getTicketByUserId(id);
//        return ResponseEntity.ok(ticket);
//    }

//    @RequestMapping(value = "/tickets/{userName}", method = RequestMethod.GET)
//    public ResponseEntity<List<Ticket>> getTicketByUsername(@PathVariable(name = "userName") String userName){
//        List<Ticket> ticket = userService.getTicketByUsername(userName);
//        return ResponseEntity.ok(ticket);
//    }



}

