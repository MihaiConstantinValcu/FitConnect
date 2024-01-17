package com.example.fitconnect.workout_exercise.api;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WorkoutExerciseByIdDto {
    private String workoutSessionId;
    private String exerciseId;
    private Integer repetitions;
    private Integer sets;
    private BigDecimal maxWeight;
}
