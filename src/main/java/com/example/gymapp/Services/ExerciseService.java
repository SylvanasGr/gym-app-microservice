package com.example.gymapp.Services;

import com.example.gymapp.Entities.Exercise;


import java.io.StringReader;
import java.util.List;

public interface ExerciseService {

    List<Exercise> getAllExercises();
    List<String> getAllExerciseCategories();
}
