package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Services.UsersService;

import com.example.gymapp.Entities.User;
import com.example.gymapp.Exceptions.NotFoundException;
import com.example.gymapp.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepo;

    @Override
    public User getUserById(int id) {
        return usersRepo.getUserById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public User getUserByEmail(final String email) {
        return usersRepo.getUserByEmail(email).orElseThrow(NotFoundException::new);
    }
}
