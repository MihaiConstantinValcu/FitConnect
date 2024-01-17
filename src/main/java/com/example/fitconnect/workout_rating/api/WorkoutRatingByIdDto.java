package com.example.fitconnect.workout_rating.api;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutRatingByIdDto {
    @NotNull
    private Integer rating;
    @NotNull
    private String comment;
    private String workoutSessionId;
}
