package com.example.easynotes.services;

import com.example.easynotes.entities.Movie;
import com.example.easynotes.exceptions.ResourceNotFoundException;
import com.example.easynotes.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> findAllByGenre(String genre){
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        if (movies.isEmpty()){
            throw new ResourceNotFoundException("movie","genre", genre);
        }
        return movies;
    }

    public List<Movie> findAllByScoreGreaterThan(Double score){
        List<Movie> movies = movieRepository.findAllByScoreGreaterThan(score);
        if (movies.isEmpty()){
            throw new ResourceNotFoundException("movie","score", score);
        }
        return movies;
    }

    public boolean deleteMovieById(int id){
        boolean transactionOk = false;
        movieRepository.deleteMovieById(id);
        transactionOk = true;
        return transactionOk;
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public boolean deleteMovie(Movie movie){
        boolean transactionOk = false;
        movieRepository.delete(movie);
        transactionOk = true;
        return transactionOk;
    }

    public Movie updateMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie findById(int id) {
        return movieRepository.findById(id);
    }
}
