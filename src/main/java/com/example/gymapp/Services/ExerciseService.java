package com.example.gymapp.Services;

import com.example.gymapp.Entities.Exercise;
import com.example.gymapp.Enums.ExerciseCategory;


import java.util.List;

public interface ExerciseService {

    List<Exercise> getAllExercises();

    List<Exercise> getAllExercisesPerCategory(ExerciseCategory category);

    List<String> getAllExerciseCategories();

}
