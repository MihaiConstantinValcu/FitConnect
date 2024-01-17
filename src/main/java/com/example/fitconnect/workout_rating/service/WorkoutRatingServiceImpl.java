package com.example.fitconnect.workout_rating.service;

import com.example.fitconnect.workout_rating.repository.WorkoutRatingRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutRatingServiceImpl implements WorkoutRatingService{
    private final WorkoutRatingRepository workoutRatingRepository;

    public WorkoutRatingServiceImpl(WorkoutRatingRepository workoutRatingRepository) {
        this.workoutRatingRepository = workoutRatingRepository;
    }
}
