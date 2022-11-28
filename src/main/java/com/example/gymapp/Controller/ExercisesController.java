package com.example.gymapp.Controller;

import com.example.gymapp.Entities.CustomTrainerExercise;
import com.example.gymapp.Entities.Exercise;
import com.example.gymapp.Entities.composite_ids.CustomTrainerExerciseId;
import com.example.gymapp.Enums.ExerciseCategory;
import com.example.gymapp.Services.CustomTrainerExerciseService;
import com.example.gymapp.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "exercises",produces = MediaType.APPLICATION_JSON_VALUE)
public class ExercisesController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private CustomTrainerExerciseService customTrainerExerciseService;

    @GetMapping("getAll")
    public ResponseEntity<List<Exercise>> getAllExercises(){
        return new ResponseEntity<>(exerciseService.getAllExercises(),HttpStatus.OK);
    }

    @GetMapping("getCustomExercise/{trainerId}/{name}")
    public ResponseEntity<CustomTrainerExercise> getCustomTrainerExercise(@PathVariable final int trainerId,@PathVariable final String name){
        return new ResponseEntity<>(customTrainerExerciseService.getCustomTrainerExercise(new CustomTrainerExerciseId(trainerId,name)),HttpStatus.OK);
    }

    @PostMapping("insertCustomExercise")
    public ResponseEntity<CustomTrainerExercise> insertCustomTrainerExercise(@RequestBody final CustomTrainerExercise customTrainerExercise){
        return new ResponseEntity<>(customTrainerExerciseService.insertCustomTrainerExercise(customTrainerExercise),HttpStatus.OK);
    }

    @GetMapping("getAllCategories")
    public ResponseEntity<List<String>> getAllExerciseCategories(){

        return  new ResponseEntity<>(exerciseService.getAllExerciseCategories(),HttpStatus.OK);
    }
}
