package com.example.easynotes.controllers;

import com.example.easynotes.entities.Movie;
import com.example.easynotes.exceptions.ResourceNotFoundException;
import com.example.easynotes.exceptions.TransactionSuccessfulException;
import com.example.easynotes.exceptions.TransactionUnsuccessfulException;
import com.example.easynotes.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        return movieService.findAllMovies();
    }

    @GetMapping("/all/filter")
    public List<Movie> getAllMoviesFiltered(@QueryParam("genre") String genre, @QueryParam("score") Double score){
        List<Movie> moviesByGenre = new ArrayList<>();
        List<Movie> moviesByScore = new ArrayList<>();
        List<Movie> moviesFiltered = new ArrayList<>();
        {
            if (genre != null){
                moviesByGenre = movieService.findAllByGenre(genre);
            }
            if (score != null){
                moviesByScore = movieService.findAllByScoreGreaterThan(score);
            }
        }
        moviesFiltered.addAll(moviesByScore);
        moviesFiltered.addAll(moviesByGenre);
        return moviesFiltered;
    }


    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable(value = "id") Integer id){
        Movie movie = movieService.findById(id);
        boolean ok = movieService.deleteMovie(movie);
        if (ok){
            throw new TransactionSuccessfulException("movie with id "+ id +" has been deleted");
        }
        throw new TransactionUnsuccessfulException("movie with id " + id + " does not exist");
    }


    @PostMapping()
    public Movie saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable(value = "id") Integer id, @RequestBody Movie movie){
        Movie updatedMovie = movieService.findById(id);
        if (movie == null){
            throw new ResourceNotFoundException("movie","id",id);
        }

        updatedMovie.setDescription(movie.getDescription());
        updatedMovie.setGenre(movie.getGenre());
        updatedMovie.setName(movie.getName());
        updatedMovie.setScore(movie.getScore());

        return movieService.updateMovie(updatedMovie);
    }
}
