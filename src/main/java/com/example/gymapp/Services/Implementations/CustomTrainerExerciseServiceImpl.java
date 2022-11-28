package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Dtos.CustomTrainerExerciseDto;
import com.example.gymapp.Entities.CustomTrainerExercise;
import com.example.gymapp.Entities.composite_ids.CustomTrainerExerciseId;
import com.example.gymapp.Exceptions.GenericException;
import com.example.gymapp.Repositories.CustomTrainerExerciseRepository;
import com.example.gymapp.Services.CustomTrainerExerciseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomTrainerExerciseServiceImpl implements CustomTrainerExerciseService {

    @Autowired
    private CustomTrainerExerciseRepository customTrainerExerciseRepository;

    @Autowired
    private UsersServiceImpl usersService;

    @Override
    public List<CustomTrainerExerciseDto> getCustomTrainerExercisesByTrainerId(int trainerId) {
        isTrainerExists(trainerId);
        List<CustomTrainerExercise> customTrainerExercises = customTrainerExerciseRepository.findAllByTrainerId(trainerId);
        return customTrainerExercises.stream().map(CustomTrainerExerciseDto::new).collect(Collectors.toList());
    }

    @Override
    public CustomTrainerExerciseDto insertCustomTrainerExercise(CustomTrainerExerciseDto customTrainerExerciseDto) {
        isTrainerExists(customTrainerExerciseDto.getTrainerId());
        CustomTrainerExerciseId customTrainerExerciseId = new CustomTrainerExerciseId(customTrainerExerciseDto.getTrainerId(), customTrainerExerciseDto.getName());
        if (customTrainerExerciseRepository.existsById(customTrainerExerciseId))
            throw new GenericException(String.format("Custom trainer exercise with id: %s already exists", customTrainerExerciseId));
        CustomTrainerExercise customTrainerExercise = new CustomTrainerExercise();
        BeanUtils.copyProperties(customTrainerExerciseDto, customTrainerExercise);
        customTrainerExerciseRepository.save(customTrainerExercise);
        return new CustomTrainerExerciseDto(customTrainerExercise);
    }

    @Override
    public CustomTrainerExerciseDto updateCustomTrainerExercise(CustomTrainerExerciseId customTrainerExerciseId, CustomTrainerExerciseDto customTrainerExercise) {
        isTrainerExists(customTrainerExerciseId.getTrainerId());
        customTrainerExerciseRepository.findById(customTrainerExerciseId).orElseThrow(() -> new GenericException(String.format("Custom Trainer Exercise with Id: %s does not exists.", customTrainerExerciseId)));
        if(!Objects.equals(customTrainerExerciseId,new CustomTrainerExerciseId(customTrainerExercise.getTrainerId(), customTrainerExercise.getName())))
            throw new GenericException(String.format("The Custom trainer Id: %s is not the same as the original: trainerId: %s, courseName: %s",customTrainerExerciseId,customTrainerExercise.getTrainerId(),customTrainerExerciseId.getName()));
        CustomTrainerExercise saveCustomTrainerExercise = new CustomTrainerExercise();
        BeanUtils.copyProperties(customTrainerExercise,saveCustomTrainerExercise);
        customTrainerExerciseRepository.save(saveCustomTrainerExercise);
        return customTrainerExercise;
    }

    @Override
    public void deleteCustomTrainerExercise(CustomTrainerExerciseId customTrainerExerciseId) {
        isTrainerExists(customTrainerExerciseId.getTrainerId());
        customTrainerExerciseRepository.findById(customTrainerExerciseId).orElseThrow(() -> new GenericException(String.format("Custom Trainer Exercise with Id: %s does not exists.", customTrainerExerciseId)));
        customTrainerExerciseRepository.deleteById(customTrainerExerciseId);
    }

    //todo: refactored this code
    private void isTrainerExists(int trainerId){
        try{
            usersService.getTrainerById(trainerId);
        }catch (Exception e){
            throw new GenericException(String.format("Trainer with id: %s does not exists",trainerId));
        }
    }
}
