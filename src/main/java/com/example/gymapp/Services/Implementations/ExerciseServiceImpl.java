package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Entities.Exercise;
import com.example.gymapp.Repositories.ExerciseRepository;
import com.example.gymapp.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }
}
