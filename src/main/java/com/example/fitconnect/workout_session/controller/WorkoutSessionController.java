package com.example.fitconnect.workout_session.controller;

import com.example.fitconnect.workout_exercise.api.WorkoutExerciseByIdDto;
import com.example.fitconnect.workout_rating.api.WorkoutRatingByIdDto;
import com.example.fitconnect.workout_rating.service.WorkoutRatingService;
import com.example.fitconnect.workout_session.api.WorkoutSessionByIdDto;
import com.example.fitconnect.workout_session.service.WorkoutSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.fitconnect.workout_session.controller.WorkoutSessionController.WORKOUT_SESSION_URL;

@RestController
@RequestMapping(WORKOUT_SESSION_URL)
public class WorkoutSessionController {
    public final static String WORKOUT_SESSION_URL = "/workout-sessions";

    private final WorkoutSessionService workoutSessionService;
    private final WorkoutRatingService workoutRatingService;

    public WorkoutSessionController(WorkoutSessionService workoutSessionService, WorkoutRatingService workoutRatingService) {
        this.workoutSessionService = workoutSessionService;
        this.workoutRatingService = workoutRatingService;
    }

    @PostMapping
    public ResponseEntity<WorkoutSessionByIdDto> save(@RequestBody WorkoutSessionByIdDto payload){
        return ResponseEntity.ok(workoutSessionService.save(payload));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutSessionByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(workoutSessionService.getById(id));
    }

    @PatchMapping("/{id}/add-exercises")
    public ResponseEntity<WorkoutSessionByIdDto> addExercises(@PathVariable String id,
                                                              @RequestBody List<WorkoutExerciseByIdDto> payload){
        return ResponseEntity.ok(workoutSessionService.addExercises(id, payload));
    }

    @PostMapping("/{id}/ratings")
    public ResponseEntity<WorkoutRatingByIdDto> addRating(@PathVariable String id,
                                                          @RequestBody WorkoutRatingByIdDto payload){
        return ResponseEntity.ok(workoutRatingService.save(id, payload));
    }

    @GetMapping("/{id}/ratings")
    public ResponseEntity<List<WorkoutRatingByIdDto>> getAllRatings(@PathVariable String id){
        return ResponseEntity.ok(workoutRatingService.getAllByWorkoutId(id));
    }
}
