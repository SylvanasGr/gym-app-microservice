package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Entities.Exercise;
import com.example.gymapp.Enums.ExerciseCategory;
import com.example.gymapp.Repositories.ExerciseRepository;
import com.example.gymapp.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @Override
    public List<String> getAllExerciseCategories() {
        List<String> exerciseCategories = new ArrayList<>();
        exerciseCategories.add(ExerciseCategory.SHOULDERS.getDescription());
        exerciseCategories.add(ExerciseCategory.LEGS.getDescription());
        exerciseCategories.add(ExerciseCategory.ABS.getDescription());
        exerciseCategories.add(ExerciseCategory.ARMS.getDescription());
        exerciseCategories.add(ExerciseCategory.CHEST.getDescription());
        exerciseCategories.add(ExerciseCategory.BACK.getDescription());
        return  exerciseCategories;
    }

}
