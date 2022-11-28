package com.example.gymapp.Enums;

import com.example.gymapp.Entities.Exercise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExerciseCategory {
    CHEST("Chest"),
    BACK("Back"),
    SHOULDERS("Shoulders"),
    ARMS("Arms"),
    ABS("Abdominal"),
    LEGS("Legs");

    private String description;


}
