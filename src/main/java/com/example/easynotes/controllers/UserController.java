package com.example.easynotes.controllers;

import com.example.easynotes.entities.User;
import com.example.easynotes.exceptions.ResourceNotFoundException;
import com.example.easynotes.exceptions.TransactionSuccessfulException;
import com.example.easynotes.exceptions.TransactionUnsuccessfulException;
import com.example.easynotes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id){
        return userService.findUserById(id);

    }

    @RequestMapping(value="/filter", method = RequestMethod.GET)
    public User getUserByUsername(@QueryParam("username") String username){
        return userService.findUserByUsername(username);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable(value = "id") Integer id, @RequestBody User userDetails){
        User user = userService.findUserById(id);
        if (user == null){
            throw new ResourceNotFoundException("User", "id", id);
        }

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());

        User updatedUser = userService.updateUser(user);
        return updatedUser;
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer id){
        User user = userService.findUserById(id);
        boolean ok = userService.deleteUser(user);
        if (ok){
            throw new TransactionSuccessfulException("user with id "+ id +" has been deleted");
        }
        throw new TransactionUnsuccessfulException("user with id " + id + " does not exist");
    }

}
