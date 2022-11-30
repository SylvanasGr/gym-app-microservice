package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Dtos.CourseDto;
import com.example.gymapp.Entities.Course;
import com.example.gymapp.Entities.composite_ids.CourseId;
import com.example.gymapp.Exceptions.GenericException;
import com.example.gymapp.Repositories.CourseRepository;
import com.example.gymapp.Services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UsersServiceImpl usersService;

    @Override
    public List<CourseDto> getCoursesPerTrainer(int trainerId) {
        return courseRepository.findAllByTrainerId(trainerId).stream().map(CourseDto::new).collect(Collectors.toList());
    }

    @Override
    public CourseDto insertCourse(CourseDto courseDto) {
        CourseId courseId = new CourseId(courseDto.getName(), courseDto.getTrainerId());
        if (courseRepository.existsById(courseId))
            throw new GenericException(String.format("Course with id: %s already exists", courseId));
        Course course = new Course();
        BeanUtils.copyProperties(courseDto, course);
        courseRepository.save(course);
        return courseDto;
    }

    @Override
    public CourseDto updateCourse(CourseId courseId, CourseDto courseDto) {
        usersService.isTrainerExists(courseDto.getTrainerId());
        courseRepository.findById(courseId).orElseThrow(() -> new GenericException(String.format("Course with Id: %s does not exists.", courseDto)));
        if (!Objects.equals(courseId, new CourseId(courseDto.getName(), courseDto.getTrainerId())))
            throw new GenericException(String.format("The Course with Id: %s is not the same as the original: trainerId: %s, courseName: %s", courseId, courseDto.getTrainerId(), courseDto.getName()));
        Course course = new Course();
        BeanUtils.copyProperties(courseDto, course);
        courseRepository.save(course);
        return courseDto;
    }

    @Override
    public void deleteCourse(CourseId courseId) {
        usersService.isTrainerExists(courseId.getTrainerId());
        courseRepository.findById(courseId).orElseThrow(() -> new GenericException(String.format("Course with Id: %s does not exists.", courseId)));
        courseRepository.deleteById(courseId);
    }
}
