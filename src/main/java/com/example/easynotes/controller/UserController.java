package com.example.easynotes.controller;

import com.example.easynotes.dto.UserAutentificationDataDto;
import com.example.easynotes.dto.UserLogedInDto;
import com.example.easynotes.model.User;
import com.example.easynotes.service.PasswordEncryption;
import com.example.easynotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> findById (){
        return userService.findAll();
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user){
        PasswordEncryption passwordEncription = new PasswordEncryption();
        user.setPassword(passwordEncription.encriptPassword(user.getPassword()));
        System.out.println("saving user");
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public UserLogedInDto login(@RequestBody UserAutentificationDataDto user){
        return userService.login(user);
    }
}
