package com.example.fitconnect.exercise.exercise_controller;

import com.example.fitconnect.exercise.ExerciseService.ExerciseService;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fitconnect.exercise.exercise_controller.ExerciseController.EXERCISE_URL;

@RestController
@RequestMapping(EXERCISE_URL)
public class ExerciseController {
    public final static String EXERCISE_URL = "/exercises";

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/{id}")
    ResponseEntity<ExerciseByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(exerciseService.getById(id));
    }

}
