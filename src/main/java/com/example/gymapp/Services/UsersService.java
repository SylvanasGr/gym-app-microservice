package com.example.gymapp.Services;

import com.example.gymapp.Entities.Trainee;
import com.example.gymapp.Entities.Trainer;
import com.example.gymapp.Entities.User;

public interface UsersService {

    User getUserById(int id);
    User getUserByEmail(final String email);
}
