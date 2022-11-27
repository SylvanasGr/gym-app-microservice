package com.example.gymapp.Entities.composite_ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseId  implements Serializable {
    @Serial
    private static final long serialVersionUID = -1L;
    private int id;
    private int trainerId;

}
