package com.example.gymapp.Services;

import java.util.List;

import com.example.gymapp.Entities.Trainee;
import com.example.gymapp.Entities.Trainer;
import com.example.gymapp.Entities.User;

public interface UsersService {

    User getUserById(int id);
    User getUserByEmail(final String email);
    Trainee getTraineeById(int id);
    Trainee getTraineeByEmail(final String email);
    List<Trainee> getTrainees();
    Trainer getTrainerById(int id);
    Trainer getTrainerByEmail(final String email);
    List<Trainer> getTrainers();
}
