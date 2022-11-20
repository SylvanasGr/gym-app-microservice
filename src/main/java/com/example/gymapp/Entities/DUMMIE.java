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
@Table(name = "DUMMIES")
public class DUMMIE {

    @Id
    @Column(name = "DUMMY_ID")
    private String dummyId;
    @Column(name = "DESCRIPTION")
    private String description;
}
