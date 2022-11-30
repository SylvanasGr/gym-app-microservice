package com.example.gymapp.Repositories;

import com.example.gymapp.Entities.Course;
import com.example.gymapp.Entities.composite_ids.CourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, CourseId> {

    List<Course> findAllByTrainerId(final int trainerId);
}
