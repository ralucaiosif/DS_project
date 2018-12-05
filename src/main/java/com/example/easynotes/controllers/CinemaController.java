package com.example.easynotes.controllers;

import com.example.easynotes.entities.Cinema;
import com.example.easynotes.exceptions.ResourceNotFoundException;
import com.example.easynotes.exceptions.TransactionSuccessfulException;
import com.example.easynotes.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    List<Cinema> getAll(){
        return cinemaService.findAll();
    }

    @GetMapping("/{id}")
    Cinema findById(@PathVariable(value = "id") Integer id){
        return cinemaService.findCinemaById(id);
    }

    @PostMapping()
    Cinema saveCinema(@RequestBody Cinema cinema){
        return cinemaService.saveCinema(cinema);
    }

    @DeleteMapping("/{id}")
    void deleteCinema(@PathVariable(value = "id") Integer id){
        Cinema cinema = cinemaService.findCinemaById(id);
        boolean transactionOk = cinemaService.deleteCinema(cinema);
        if (transactionOk){
            throw new TransactionSuccessfulException("cinema " + id + " deleted");
        }
        else{
            throw new ResourceNotFoundException("cinema", "id", id);
        }
    }

    @PutMapping("/{id}")
    Cinema updateCinema(@PathVariable(value = "id") Integer id, @RequestBody Cinema cinema){
        Cinema updatedCinema = cinemaService.findCinemaById(id);
        updatedCinema.setAddress(cinema.getAddress());
        updatedCinema.setName(cinema.getName());
        return cinemaService.saveCinema(updatedCinema);
    }
}
