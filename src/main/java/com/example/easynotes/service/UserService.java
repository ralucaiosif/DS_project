package com.example.easynotes.service;

import com.example.easynotes.dto.UserAutentificationDataDto;
import com.example.easynotes.dto.UserLogedInDto;
import com.example.easynotes.exception.TransactionUnsuccessfulException;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public UserLogedInDto login(UserAutentificationDataDto user){
        System.out.println(user.getUsername());
        User existingUser = findUserByUsername(user.getUsername());
        UserLogedInDto userDto = new UserLogedInDto(existingUser.getUsername(), existingUser.getEmail());
        System.out.println(existingUser.getId());
        userDto.setId(existingUser.getId());
        userDto.setFirstName(existingUser.getFirstName());
        userDto.setLastName(existingUser.getLastName());
        PasswordEncryption passwordEncription = new PasswordEncryption();
        if (passwordEncription.matches(user.getPassword(), existingUser.getPassword())){
            return userDto;
        }
        return null;
    }

    public User saveUser(User user)  {
        if (findUserByUsername(user.getUsername()) != null){
            throw new TransactionUnsuccessfulException("Username already exists.");
        }
        return userRepository.save(user);
    }

}
