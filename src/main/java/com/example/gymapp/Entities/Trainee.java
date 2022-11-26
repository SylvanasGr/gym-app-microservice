package com.example.gymapp.Entities;

import lombok.Data;


@Data
public class Trainee extends User {

    public Trainee(User u) {
        setUserFields(u);
    }

    private float weight;
    private float height;
    private String injuries;
}
