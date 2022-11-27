package com.example.gymapp.Services;

import com.example.gymapp.Entities.CustomTrainerExercise;
import com.example.gymapp.Entities.composite_ids.CustomTrainerExerciseId;

public interface CustomTrainerExerciseService {

    CustomTrainerExercise getCustomTrainerExercise(final CustomTrainerExerciseId customTrainerExerciseId);
    CustomTrainerExercise insertCustomTrainerExercise(final CustomTrainerExercise customTrainerExercise);
}
