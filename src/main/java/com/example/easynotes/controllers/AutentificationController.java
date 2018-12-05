package com.example.easynotes.controllers;

import com.example.easynotes.dto.UserAutentificationDataDto;
import com.example.easynotes.entities.User;
import com.example.easynotes.exceptions.InvalidCredentialsException;
import com.example.easynotes.services.AutentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutentificationController {

    @Autowired
    private AutentificationService autentificationService;

    @GetMapping()
    @ResponseBody
    public User autentificate(@RequestBody UserAutentificationDataDto userData){
        User user = autentificationService.login(userData);
        if (user == null){
            throw new InvalidCredentialsException("Invalid credentials");
        }
        // valid credentials, user logs in so a session is created
        return user;
    }
}
