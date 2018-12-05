package com.example.easynotes.services;

import com.example.easynotes.dto.UserAutentificationDataDto;
import com.example.easynotes.entities.User;
import com.example.easynotes.repositories.UserRepository;
import com.example.easynotes.services.security.PasswordEncription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class AutentificationService {

    @Autowired
    private UserRepository userJpaRepository;

    private PasswordEncription passwordEncription;

    @GetMapping("/login")
    @ResponseBody
    public User login(UserAutentificationDataDto userData){
        User existingUser = userJpaRepository.findByUsername(userData.getUsername());
        String providedPass = new String(userData.getPassword());
        if (existingUser.getPassword().equals(providedPass)){
//            existingUser.setPassword(passwordEncription.encript(userData.getPassword()));
            return existingUser;
        }
        return null;
    }
}
