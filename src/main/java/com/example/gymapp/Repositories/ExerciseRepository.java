package com.example.gymapp.Repositories;

import com.example.gymapp.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExerciseRepository  extends JpaRepository<Exercise,String> {

}
