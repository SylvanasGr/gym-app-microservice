package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Services.UsersService;
import com.example.gymapp.Entities.Trainee;
import com.example.gymapp.Entities.Trainer;
import com.example.gymapp.Entities.User;
import com.example.gymapp.Repositories.UsersRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepo;

    @Override
    public User getUserById(int id) {
        return usersRepo.getUserById(id);
    }

    @Override
    public User getUserByEmail(final String email) {
        return usersRepo.getUserByEmail(email);
    }

    @Override
    public Trainee getTraineeById(int id) {
        return usersRepo.getTraineeById(id);
    }

    @Override
    public List<Trainee> getTrainees() {
        return usersRepo.getTrainees();
    }

    @Override
    public Trainee getTraineeByEmail(final String email) {
        return usersRepo.getTraineeByEmail(email);
    }

    @Override
    public Trainer getTrainerById(int id) {
        return usersRepo.getTrainerById(id);
    }

    @Override
    public Trainer getTrainerByEmail(final String email) {
        return usersRepo.getTrainerByEmail(email);
    }

    @Override
    public List<Trainer> getTrainers() {
        return usersRepo.getTrainers();
    }
}
