package com.example.gymapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gymapp.Entities.User;
import com.example.gymapp.Services.UsersService;


@RestController
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    @GetMapping("id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(usersService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable final String email) {
        return new ResponseEntity<>(usersService.getUserByEmail(email), HttpStatus.OK);
    }

}
