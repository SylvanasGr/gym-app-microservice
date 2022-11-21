package com.example.gymapp.Entities.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Sex {
    MALE("M"),
    FEMALE("F");

    private String s;    
}
