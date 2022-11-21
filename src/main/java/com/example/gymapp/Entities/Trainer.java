package com.example.gymapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.gymapp.Entities.Enums.TrainerType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Trainers")
public class Trainer {
    
    @Id
    @Column(name = "UserId")
    private int userId;
    @Column(name = "TrainerTypeId")
    private TrainerType trainerTypeId;
    @Column(name = "BankAccount")
    private String bankAccount;
    @Column(name = "ProfileDescription")
    private String profileDescription;
}
