package com.example.gymapp.Controller;

import com.example.gymapp.Dtos.CustomTrainerExerciseDto;
import com.example.gymapp.Entities.Exercise;
import com.example.gymapp.Entities.composite_ids.CustomTrainerExerciseId;
import com.example.gymapp.Services.CustomTrainerExerciseService;
import com.example.gymapp.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "exercises", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExercisesController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private CustomTrainerExerciseService customTrainerExerciseService;

    @GetMapping("getAll")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return new ResponseEntity<>(exerciseService.getAllExercises(), HttpStatus.OK);
    }

    @GetMapping("getCustomTrainerExercises/{trainerId}")
    public ResponseEntity<List<CustomTrainerExerciseDto>> getCustomTrainerExercisesByTrainerId(@PathVariable final int trainerId) {
        return new ResponseEntity<>(customTrainerExerciseService.getCustomTrainerExercisesByTrainerId(trainerId), HttpStatus.OK);
    }

    @PostMapping("insertCustomTrainerExercise")
    public ResponseEntity<CustomTrainerExerciseDto> insertCustomTrainerExercise(@RequestBody @Valid final CustomTrainerExerciseDto customTrainerExerciseDto) {
        return new ResponseEntity<>(customTrainerExerciseService.insertCustomTrainerExercise(customTrainerExerciseDto), HttpStatus.OK);
    }

    @PutMapping("updateCustomTrainerExercise/{trainerId}/{exerciseName}")
    public ResponseEntity<CustomTrainerExerciseDto> updateCustomTrainerExercise(
            @PathVariable final int trainerId,
            @PathVariable final String exerciseName,
            @RequestBody @Valid final CustomTrainerExerciseDto customTrainerExerciseDto) {
        return new ResponseEntity<>(customTrainerExerciseService.updateCustomTrainerExercise(new CustomTrainerExerciseId(trainerId, exerciseName), customTrainerExerciseDto), HttpStatus.OK);
    }

    @DeleteMapping("deleteCustomTrainerExercise/{trainerId}/{exerciseName}")
    public ResponseEntity<Void> deleteCustomTrainerExercise(
            @PathVariable final int trainerId,
            @PathVariable final String exerciseName) {
        customTrainerExerciseService.deleteCustomTrainerExercise(new CustomTrainerExerciseId(trainerId, exerciseName));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getAllCategories")
    public ResponseEntity<List<String>> getAllExerciseCategories() {

        return new ResponseEntity<>(exerciseService.getAllExerciseCategories(), HttpStatus.OK);
    }
}
