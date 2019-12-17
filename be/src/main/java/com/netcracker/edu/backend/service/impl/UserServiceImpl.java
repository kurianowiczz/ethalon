package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public User addUser(User newUser){
        //newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    /*@Override
    public User getUserByUserNameAndPassword(String userName, String password) {
        return userRepository.getUserByUserNameAndPassword(userName, password);
    }*/

//    @Override
//    public User getUserById(Long id) {
//        return userRepository.getUserById(id);
//    }


//    @Override
//    public List<Ticket> getTicketByUserId(Long id) {
//        return userRepository.getTicketByUserId(id);
//    }

//    @Override
//    public List<Ticket> getTicketByUsername(String userName) {
//        return userRepository.getTicketByUsername(userName);
//    }
}
