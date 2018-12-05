package com.example.easynotes.controllers;

import com.example.easynotes.entities.Movie;
import com.example.easynotes.exceptions.ResourceNotFoundException;
import com.example.easynotes.services.UserMoviesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-movies")
public class UserMoviesListController {

    @Autowired
    private UserMoviesListService userMoviesListService;

    @GetMapping("/{userId}")
    public List<Movie> getUserMovies(@PathVariable(value = "userId") Integer id){
        List<Movie> movies = userMoviesListService.getUserMovies(id);
        if (movies.isEmpty()){
            throw new ResourceNotFoundException("user-movies", "user id", id);
        }
        return movies;
    }

    @GetMapping("/{userId}/suggestions")
    public List<Movie> getSuggestedMovies(@PathVariable(value = "userId") Integer id){
        return  userMoviesListService.getSuggestedMovies(id);
    }
}
