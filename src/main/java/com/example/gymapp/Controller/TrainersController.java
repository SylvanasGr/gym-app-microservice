package com.example.gymapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gymapp.Entities.jdbc.Trainer;
import com.example.gymapp.Services.UsersService;


@RestController
@RequestMapping(value = "trainers", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainersController {
    
    @Autowired
    private UsersService usersService;

    @GetMapping("id/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable int id) {
        return new ResponseEntity<>(usersService.getTrainerById(id), HttpStatus.OK);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<Trainer> getTrainerByEmail(@PathVariable String email) {
        return new ResponseEntity<>(usersService.getTrainerByEmail(email), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Trainer>> getTrainers() {
        return new ResponseEntity<>(usersService.getTrainers(), HttpStatus.OK);
    }
}
