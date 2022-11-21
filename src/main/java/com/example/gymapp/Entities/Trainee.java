package com.example.gymapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Trainees")
public class Trainee {

    @Id
    @Column(name = "UserId")
    private int userId;
    @Column(name = "Weight")
    private float weight;
    @Column(name = "Height")
    private float height;
    @Column(name = "Injuries")
    private String injuries;
}
