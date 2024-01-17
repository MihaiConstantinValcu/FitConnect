package com.example.fitconnect.workout_session.controller;

import com.example.fitconnect.workout_exercise.api.WorkoutExerciseByIdDto;
import com.example.fitconnect.workout_rating.api.WorkoutRatingByIdDto;
import com.example.fitconnect.workout_rating.service.WorkoutRatingService;
import com.example.fitconnect.workout_session.api.WorkoutSessionByIdDto;
import com.example.fitconnect.workout_session.service.WorkoutSessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "Get all workout sessions")
    @GetMapping
    public ResponseEntity<List<WorkoutSessionByIdDto>> getAll(){
        return ResponseEntity.ok(workoutSessionService.getAll());
    }

    @Operation(summary = "Add new workout session",
            description = "Adds a new workout session with details and a list of workout exercises")
    @Parameter(name = "payload", description = "Workout session details", required = true)
    @PostMapping
    public ResponseEntity<WorkoutSessionByIdDto> save(@RequestBody @Valid WorkoutSessionByIdDto payload){
        return ResponseEntity.ok(workoutSessionService.save(payload));
    }

    @Operation(summary = "Get workout session based on specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Workout Session information was successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "The Workout Session with the provided ID doesn't exist")
    })
    @Parameter(name = "id", description = "Workout session ID", required = true)
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutSessionByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(workoutSessionService.getById(id));
    }

    @Operation(summary = "Add exercise to workout session",
            description = "Adds a new exercise to the workout session")
    @Parameter(name = "payload", description = "A list of exercises to be added to workout session", required = true)
    @Parameter(name = "id", description = "Workout session ID", required = true)
    @PatchMapping("/{id}/add-exercises")
    public ResponseEntity<WorkoutSessionByIdDto> addExercises(@PathVariable String id,
                                                              @RequestBody @Valid List<WorkoutExerciseByIdDto> payload){
        return ResponseEntity.ok(workoutSessionService.addExercises(id, payload));
    }

    @Operation(summary = "Add  rating for workout session",
            description = "Adds a new rating for the workout session")
    @Parameter(name = "payload", description = "The rating informations", required = true)
    @Parameter(name = "id", description = "Workout session ID", required = true)
    @PostMapping("/{id}/ratings")
    public ResponseEntity<WorkoutRatingByIdDto> addRating(@PathVariable String id,
                                                          @RequestBody @Valid WorkoutRatingByIdDto payload){
        return ResponseEntity.ok(workoutRatingService.save(id, payload));
    }

    @Operation(summary = "Get all ratings for a workout session")
    @Parameter(name = "id", description = "Workout session ID", required = true)
    @GetMapping("/{id}/ratings")
    public ResponseEntity<List<WorkoutRatingByIdDto>> getAllRatings(@PathVariable String id){
        return ResponseEntity.ok(workoutRatingService.getAllByWorkoutId(id));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnexpectedErrors(Exception e) {
        return e.getMessage();
    }
}
