package com.example.gymapp.Dtos;

import com.example.gymapp.Entities.CustomTrainerExercise;
import com.example.gymapp.Enums.ExerciseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomTrainerExerciseDto {
    @Min(1)
    private int trainerId;
    @NotEmpty()
    private String name;
    @NotEmpty
    private ExerciseCategory exerciseCategory;
    @NotEmpty
    private String equipmentDescription;
    @NotEmpty
    private String videoUrl;
    @NotEmpty
    private String imageUrl;

    public CustomTrainerExerciseDto(CustomTrainerExercise customTrainerExercise) {
        BeanUtils.copyProperties(customTrainerExercise, this);
    }


}
