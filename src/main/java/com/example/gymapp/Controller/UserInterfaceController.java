package com.example.gymapp.Controller;

import com.example.gymapp.Entities.DUMMIE;
import com.example.gymapp.Services.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "ui", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserInterfaceController {

    @Autowired
    private UserInterfaceService userInterfaceService;

    @GetMapping("getDummie/{dummieId}")
    public ResponseEntity<DUMMIE> getDummieById(@PathVariable final String dummieId) {
        return new ResponseEntity<>(userInterfaceService.getDummieById(dummieId), HttpStatus.OK);
    }

    @PostMapping("insertDummie")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DUMMIE> insertDummie(@RequestBody final DUMMIE dummie) {
        return new ResponseEntity<>(userInterfaceService.insertDummie(dummie),HttpStatus.CREATED);
    }

    @DeleteMapping("deleteDummie/{dummieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<DUMMIE> deleteDummie(@PathVariable final String dummieId) {
        userInterfaceService.deleteDummie(dummieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
