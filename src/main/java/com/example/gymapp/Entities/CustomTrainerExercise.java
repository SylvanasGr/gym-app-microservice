package com.example.gymapp.Entities;

import com.example.gymapp.Entities.composite_ids.CustomTrainerExerciseId;
import com.example.gymapp.Enums.ExerciseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customtrainerexercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CustomTrainerExerciseId.class)
public class CustomTrainerExercise {

    @Id
    @Column(name = "trainerid",nullable = false)
    private int trainerId;
    @Id
    @Column(name = "name",nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ExerciseCategory exerciseCategory;
    @Column(name = "equipmentdescription")
    private String equipmentDescription;
    @Column(name = "videourl")
    private String videoUrl;
    @Column(name = "imageurl")
    private String imageUrl;

}
