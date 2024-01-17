package com.example.fitconnect.exercise.controller;

import com.example.fitconnect.exercise.service.ExerciseService;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.fitconnect.exercise.controller.ExerciseController.EXERCISE_URL;

@RestController
@RequestMapping(EXERCISE_URL)
public class ExerciseController {
    public final static String EXERCISE_URL = "/exercises";

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Operation(summary = "Get exercise based on specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Exercise information was successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "The Exercise with the provided ID doesn't exist")
    })
    @Parameter(name = "id", description = "Exercise ID", required = true)
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(exerciseService.getById(id));
    }

    @Operation(summary = "Get all exercises")
    @GetMapping
    public ResponseEntity<List<ExerciseByIdDto>> getAll(){
        return ResponseEntity.ok(exerciseService.getAll());
    }

    @Operation(summary = "Create an exercise",
            description = "Creates a new exercise based on the information received in the request")
    @Parameter(name = "payload", description = "Exercise details", required = true)
    @Parameter(name = "categoryId", description = "Category Id", required = true)
    @PostMapping("/categoryId/{categoryId}")
    public ResponseEntity<ExerciseByIdDto> save(@RequestBody @Valid ExerciseByIdDto payload,
                                                @PathVariable String categoryId){
        return ResponseEntity.ok(exerciseService.save(payload, categoryId));
    }

    @Operation(summary = "Delete an exercise",
            description = "Delete the exercise from the database")
    @Parameter(name = "id", description = "The id of the exercise to be deleted", required = true)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        exerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
