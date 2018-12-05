package com.example.easynotes.services;

import com.example.easynotes.entities.User;
import com.example.easynotes.exceptions.ResourceNotFoundException;
import com.example.easynotes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userJpaRepository;

    public User findUserById(int userId) {
        User usr = userJpaRepository.findById(userId);
        if (usr == null) {
           throw new ResourceNotFoundException("user","id",userId);
        }
        return usr;
    }

    public User findUserByUsername(String username){
        User user = userJpaRepository.findByUsername(username);
        if (user == null){
            throw new ResourceNotFoundException("user", "username", username);
        }
        return user;
    }

    public List<User> findAll() {
        List<User> users = userJpaRepository.findAll();
        return users;
    }

    public User saveUser(User user){
        return userJpaRepository.save(user);
    }

    public User updateUser(User user){
        return userJpaRepository.save(user);
    }

    public boolean deleteUser(User user){
        boolean transactionOk = false;
        userJpaRepository.delete(user);
        transactionOk = true;
        return transactionOk;
    }




}
