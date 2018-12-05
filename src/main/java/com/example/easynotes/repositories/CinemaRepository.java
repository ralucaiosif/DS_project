package com.example.easynotes.repositories;

import com.example.easynotes.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

    List<Cinema> findAll();

    Cinema findById(int id);

    void deleteCinemaById(int id);

}
