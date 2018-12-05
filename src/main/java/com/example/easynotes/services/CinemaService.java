package com.example.easynotes.services;

import com.example.easynotes.entities.Cinema;
import com.example.easynotes.exceptions.ResourceNotFoundException;
import com.example.easynotes.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> findAll(){
        return cinemaRepository.findAll();
    }

    public boolean deleteCinemaById(int id){
        boolean transactionOk = false;
        cinemaRepository.deleteCinemaById(id);
        transactionOk = true;
        return transactionOk;
    }

    public Cinema findCinemaById(int id){
        Cinema cinema = cinemaRepository.findById(id);
        if (cinema == null){
            throw new ResourceNotFoundException("cinema", "id", id);
        }
        return cinema;
    }

    public Cinema updateCinema(Cinema cinema){
        return cinemaRepository.save(cinema);
    }

    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public boolean deleteCinema(Cinema cinema) {
        boolean transactionOk = false;
        cinemaRepository.delete(cinema);
        transactionOk = true;
        return transactionOk;
    }
}
