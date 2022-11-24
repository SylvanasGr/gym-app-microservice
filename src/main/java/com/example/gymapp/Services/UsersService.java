package com.example.gymapp.Services;

import com.example.gymapp.Entities.User;

public interface UsersService {

    User getUserById(int id);
    User getUserByEmail(final String email);
}
