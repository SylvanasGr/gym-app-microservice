package com.example.gymapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.gymapp.Entities.Enums.TrainerType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {
    
    private int userId;
    private TrainerType trainerTypeId;
    private String bankAccount;
    private String profileDescription;
}
