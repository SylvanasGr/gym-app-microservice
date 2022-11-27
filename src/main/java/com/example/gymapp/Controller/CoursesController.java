package com.example.gymapp.Controller;

import com.example.gymapp.Entities.Course;
import com.example.gymapp.Entities.composite_ids.CourseId;
import com.example.gymapp.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "courses", name = MediaType.APPLICATION_JSON_VALUE)
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @GetMapping("getCourse/{id}/{trainerId}")
    public ResponseEntity<Course> getCourse(@PathVariable final int id, @PathVariable final int trainerId) {
        Course course = courseService.getCourse(new CourseId(id, trainerId));
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("insertCourse")
    public ResponseEntity<Course> insertCourse(@RequestBody final Course course) {
        Course newCourse = courseService.insertCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.OK);
    }
}
