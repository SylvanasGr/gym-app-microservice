package com.example.gymapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.gymapp.Entities.Enums.Sex;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;
    private String name;
    private String surname;
    private Sex sex;
    private int age;
    private String email;
    private String username;
    private String password;
    private String country;
    private String area;
    private String phoneNumber;
}
