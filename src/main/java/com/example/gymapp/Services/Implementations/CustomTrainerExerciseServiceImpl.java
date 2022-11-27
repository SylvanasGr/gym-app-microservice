package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Entities.CustomTrainerExercise;
import com.example.gymapp.Entities.composite_ids.CustomTrainerExerciseId;
import com.example.gymapp.Exceptions.GenericException;
import com.example.gymapp.Exceptions.NotFoundException;
import com.example.gymapp.Repositories.CustomTrainerExerciseRepository;
import com.example.gymapp.Services.CustomTrainerExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomTrainerExerciseServiceImpl implements CustomTrainerExerciseService {

    @Autowired
    private CustomTrainerExerciseRepository customTrainerExerciseRepository;

    @Override
    public CustomTrainerExercise getCustomTrainerExercise(CustomTrainerExerciseId customTrainerExerciseId) {
        return customTrainerExerciseRepository.findById(customTrainerExerciseId).orElseThrow(()-> new NotFoundException(String.format("Custom trainer exercise with id: %s  not found",customTrainerExerciseId)));
    }

    @Override
    public CustomTrainerExercise insertCustomTrainerExercise(CustomTrainerExercise customTrainerExercise) {
       CustomTrainerExerciseId customTrainerExerciseId = new CustomTrainerExerciseId(customTrainerExercise.getTrainerId(),customTrainerExercise.getName());
       if(customTrainerExerciseRepository.existsById(customTrainerExerciseId))
           throw new GenericException(String.format("Custom trainer exercise with id: %s already exists",customTrainerExerciseId));
       return customTrainerExerciseRepository.save(customTrainerExercise);
    }
}
