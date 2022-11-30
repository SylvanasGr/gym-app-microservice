package com.example.gymapp.Entities;

import com.example.gymapp.Entities.composite_ids.CourseId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@IdClass(CourseId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @Column(name = "name",nullable = false)
    private String name;
    @Id
    @Column(name = "trainerid",nullable = false)
    private int trainerId;
    @Column(name = "description")
    private String description;
    @Column(name = "duration")
    private int duration;
    @Column(name = "price")
    private double price;
    @Column(name = "ispersonal")
    private boolean isPersonal;

}
