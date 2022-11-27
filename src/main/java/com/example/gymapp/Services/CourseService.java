package com.example.gymapp.Services;

import com.example.gymapp.Entities.Course;
import com.example.gymapp.Entities.composite_ids.CourseId;

public interface CourseService {

    Course getCourse(final CourseId courseId);
    Course insertCourse(final Course course);
}
