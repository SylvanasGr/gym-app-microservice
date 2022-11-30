package com.example.gymapp.Services;

import java.util.List;

import com.example.gymapp.Entities.jdbc.Trainee;
import com.example.gymapp.Entities.jdbc.Trainer;
import com.example.gymapp.Entities.jdbc.User;

public interface UsersService {

    User getUserById(int id);

    User getUserByEmail(final String email);

    Trainee getTraineeById(int id);

    Trainee getTraineeByEmail(final String email);

    List<Trainee> getTrainees();

    Trainer getTrainerById(int id);

    Trainer getTrainerByEmail(final String email);

    List<Trainer> getTrainers();

    //todo: refactored this code
    void isTrainerExists(int trainerId);
}
