package com.example.gymapp.Entities;

import lombok.Data;

import com.example.gymapp.Entities.Enums.TrainerType;

@Data
public class Trainer extends User {

    public Trainer (User u) {
        setUserFields(u);
    }
    
    private TrainerType trainerType;
    private String bankAccount;
    private String profileDescription;
}
