package com.example.gymapp.Repositories;

import com.example.gymapp.Entities.CustomTrainerExercise;
import com.example.gymapp.Entities.Exercise;
import com.example.gymapp.Entities.composite_ids.CustomTrainerExerciseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomTrainerExerciseRepository extends JpaRepository<CustomTrainerExercise, CustomTrainerExerciseId> {
}
