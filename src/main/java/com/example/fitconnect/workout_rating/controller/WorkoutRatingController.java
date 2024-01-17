package com.example.fitconnect.workout_rating.controller;

import com.example.fitconnect.workout_rating.service.WorkoutRatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fitconnect.workout_rating.controller.WorkoutRatingController.WORKOUT_RATING_URL;

@RestController
@RequestMapping(WORKOUT_RATING_URL)
public class WorkoutRatingController {
    public final static String WORKOUT_RATING_URL = "/workout-ratings";

    private final WorkoutRatingService workoutRatingService;

    public WorkoutRatingController(WorkoutRatingService workoutRatingService) {
        this.workoutRatingService = workoutRatingService;
    }

//    @GetMapping("")
}
