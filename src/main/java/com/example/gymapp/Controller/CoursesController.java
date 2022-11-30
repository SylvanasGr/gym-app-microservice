package com.example.gymapp.Controller;

import com.example.gymapp.Dtos.CourseDto;
import com.example.gymapp.Entities.Course;
import com.example.gymapp.Entities.composite_ids.CourseId;
import com.example.gymapp.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "courses", name = MediaType.APPLICATION_JSON_VALUE)
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @GetMapping("getCourses/{trainerId}")
    public ResponseEntity<List<CourseDto>> getCoursesPerTrainerId(@PathVariable final int trainerId) {
        return new ResponseEntity<>(courseService.getCoursesPerTrainer(trainerId), HttpStatus.OK);
    }

    @PostMapping("insertCourse")
    public ResponseEntity<CourseDto> insertCourse(@RequestBody @Valid final CourseDto courseDto) {
        return new ResponseEntity<>(courseService.insertCourse(courseDto), HttpStatus.OK);
    }

    @PutMapping("updateCourse/{name}/{trainerId}")
    public ResponseEntity<CourseDto> insertCourse(@PathVariable final String name, @PathVariable final int trainerId, @RequestBody @Valid final CourseDto courseDto) {
        return new ResponseEntity<>(courseService.updateCourse(new CourseId(name, trainerId), courseDto), HttpStatus.OK);
    }

    @DeleteMapping("deleteCourse/{name}/{trainerId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable final String name, @PathVariable final int trainerId) {
        courseService.deleteCourse(new CourseId(name, trainerId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
