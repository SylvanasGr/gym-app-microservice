package com.example.gymapp.Enums;

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
