package com.example.gymapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gymapp.Entities.Trainee;
import com.example.gymapp.Services.UsersService;


@RestController
@RequestMapping(value = "trainees", produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineesController {
    
    @Autowired
    private UsersService usersService;

    @GetMapping("id/{id}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable int id) {
        return new ResponseEntity<>(usersService.getTraineeById(id), HttpStatus.OK);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<Trainee> getTraineeByEmail(@PathVariable String email) {
        return new ResponseEntity<>(usersService.getTraineeByEmail(email), HttpStatus.OK);
    }
}
