package com.example.gymapp.Services;

import com.example.gymapp.Dtos.CustomTrainerExerciseDto;
import com.example.gymapp.Entities.CustomTrainerExercise;
import com.example.gymapp.Entities.composite_ids.CustomTrainerExerciseId;

import java.util.List;

public interface CustomTrainerExerciseService {

    List<CustomTrainerExerciseDto> getCustomTrainerExercisesByTrainerId(final int trainerId);
    CustomTrainerExerciseDto insertCustomTrainerExercise(final CustomTrainerExerciseDto customTrainerExerciseDto);

    CustomTrainerExerciseDto updateCustomTrainerExercise(CustomTrainerExerciseId customTrainerExerciseId, CustomTrainerExerciseDto customTrainerExerciseDto);

    void deleteCustomTrainerExercise(CustomTrainerExerciseId customTrainerExerciseId);
}
