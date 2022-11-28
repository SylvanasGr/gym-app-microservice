package com.example.gymapp.Dtos;

import com.example.gymapp.Entities.CustomTrainerExercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomTrainerExerciseDto {
    @Min(1)
    private int trainerId;
    @NotNull()
    private String name;
    @NotNull
    private String exerciseCategory;
    @NotNull
    private String equipmentDescription;
    @NotNull
    private String videoUrl;
    @NotNull
    private String imageUrl;

    public CustomTrainerExerciseDto(CustomTrainerExercise customTrainerExercise){
        BeanUtils.copyProperties(customTrainerExercise,this);
    }


}
