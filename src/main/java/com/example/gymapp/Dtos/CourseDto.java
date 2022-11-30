package com.example.gymapp.Dtos;

import com.example.gymapp.Entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    @NotEmpty
    private String name;
    @Min(1)
    private int trainerId;
    @NotEmpty
    private String description;
    @Min(1)
    private int duration;
    private double price;
    private boolean isPersonal;

    public CourseDto(Course course) {
        BeanUtils.copyProperties(course, this);
    }
}
