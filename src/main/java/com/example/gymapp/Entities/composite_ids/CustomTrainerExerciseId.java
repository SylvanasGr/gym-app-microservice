package com.example.gymapp.Entities.composite_ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomTrainerExerciseId  implements Serializable {
    @Serial
    private static final long serialVersionUID = -1L;
    private int trainerId;
    private String name;
}
