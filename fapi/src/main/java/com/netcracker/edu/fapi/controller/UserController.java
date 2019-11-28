package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") long id) {
        User user = userService.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/login/{userName}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByUserName(@PathVariable(name = "userName") String userName) {
        User user = userService.findByLogin(userName);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/current")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // todo exclude password from model!
        return userService.findByLogin(((org.springframework.security.core.userdetails.User)
                authentication.getPrincipal()).getUsername());
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public User saveUser(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable(name = "id") long id) {
        userService.delete(id);
    }
}
