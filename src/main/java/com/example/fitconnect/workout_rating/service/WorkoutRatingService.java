package com.example.fitconnect.workout_rating.service;

import com.example.fitconnect.workout_rating.api.WorkoutRatingByIdDto;

import java.util.List;

public interface WorkoutRatingService {
    List<WorkoutRatingByIdDto> getAllByWorkoutId(String id);

    WorkoutRatingByIdDto save(String id, WorkoutRatingByIdDto payload);
}
