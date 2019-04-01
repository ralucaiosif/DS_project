package com.example.easynotes.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {

    public String encriptPassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    public boolean matches(String provided, String hashed){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(provided,hashed);
    }
}
