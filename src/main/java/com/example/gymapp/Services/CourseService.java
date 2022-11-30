package com.example.gymapp.Services;

import com.example.gymapp.Dtos.CourseDto;
import com.example.gymapp.Entities.composite_ids.CourseId;

import java.util.List;

public interface CourseService {

    List<CourseDto> getCoursesPerTrainer(final int trainerId);

    CourseDto insertCourse(final CourseDto course);

    CourseDto updateCourse(CourseId courseId, CourseDto course);

    void deleteCourse(CourseId courseId);
}
