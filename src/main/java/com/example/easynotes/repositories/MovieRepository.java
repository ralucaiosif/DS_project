package com.example.easynotes.repositories;

import com.example.easynotes.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findAll();

    List<Movie> findAllByGenre(String genre);

    List<Movie> findAllByScoreGreaterThan(Double score);

    void deleteMovieById(int id);

    void delete(Movie movie);

    Movie findById(int id);

    List<Movie> findAllByGenreAndScoreBetween(String genre, Double lowScore, Double highScore);

    Movie findByName(String name);
}

