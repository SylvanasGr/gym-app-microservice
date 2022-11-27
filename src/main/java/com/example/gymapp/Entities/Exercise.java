package com.example.gymapp.Entities;

import com.example.gymapp.Enums.ExerciseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @Column(name = "name",nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoryid")
    private ExerciseCategory exerciseCategory;

}
