package com.example.fitconnect.workout_rating.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutRatingByIdDto {
    private Integer rating;
    private String comment;
    private String workoutSessionId;
}
