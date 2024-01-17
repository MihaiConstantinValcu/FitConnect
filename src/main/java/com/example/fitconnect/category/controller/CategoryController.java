package com.example.fitconnect.exercise_category.controller;

import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import com.example.fitconnect.exercise_category.api.ExerciseCategoryByIdDto;
import com.example.fitconnect.exercise_category.service.ExerciseCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.fitconnect.exercise_category.controller.ExerciseCategoryController.EXERCISE_CATEGORY_URL;

@RestController
@RequestMapping(EXERCISE_CATEGORY_URL)
public class ExerciseCategoryController {

    public final static String EXERCISE_CATEGORY_URL = "/exercise-categories";

    private final ExerciseCategoryService exerciseCategoryService;

    public ExerciseCategoryController(ExerciseCategoryService exerciseCategoryService) {
        this.exerciseCategoryService = exerciseCategoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseCategoryByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(exerciseCategoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ExerciseCategoryByIdDto> save(@RequestBody ExerciseCategoryByIdDto payload){
        return ResponseEntity.ok(exerciseCategoryService.save(payload));
    }
}
