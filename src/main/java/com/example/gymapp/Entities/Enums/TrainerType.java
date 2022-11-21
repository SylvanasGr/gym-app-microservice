package com.example.gymapp.Entities.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TrainerType {
    GYM(1),
    FREELANCER(2);

    private int id;
}
