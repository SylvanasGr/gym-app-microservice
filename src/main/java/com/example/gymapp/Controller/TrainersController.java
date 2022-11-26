package com.example.gymapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gymapp.Entities.Trainer;
import com.example.gymapp.Services.UsersService;


@RestController
@RequestMapping(value = "trainers", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainersController {
    
    @Autowired
    private UsersService usersService;

    @GetMapping("id/{id}")
    public ResponseEntity<Trainer> getTraineeById(@PathVariable int id) {
        return new ResponseEntity<>(usersService.getTrainerById(id), HttpStatus.OK);
    }
}
