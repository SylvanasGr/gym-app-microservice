package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Entities.Course;
import com.example.gymapp.Entities.composite_ids.CourseId;
import com.example.gymapp.Exceptions.GenericException;
import com.example.gymapp.Exceptions.NotFoundException;
import com.example.gymapp.Repositories.CourseRepository;
import com.example.gymapp.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course getCourse(CourseId courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException(String.format("Course with id: %s not found", courseId)));
    }

    @Override
    public Course insertCourse(Course course) {
        CourseId courseId = new CourseId(course.getId(), course.getTrainerId());
        if (courseRepository.existsById(courseId))
            throw new GenericException(String.format("Course with id: %s already exists", courseId));
        return courseRepository.save(course);
    }
}
