package com.example.easynotes.repositories;

import com.example.easynotes.entities.UserMoviesList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMoviesListRepository extends JpaRepository<UserMoviesList, Integer> {

    List<UserMoviesList> findAllByUserId(int userId);

}
