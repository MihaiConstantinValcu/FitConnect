package com.example.fitconnect.exercise.controller;

import com.example.fitconnect.exercise.service.ExerciseService;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import org.apache.coyote.BadRequestException;
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

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(exerciseService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExerciseByIdDto>> getAll(){
        return ResponseEntity.ok(exerciseService.getAll());
    }

    @PostMapping("/categoryId/{categoryId}")
    public ResponseEntity<ExerciseByIdDto> save(@RequestBody ExerciseByIdDto payload,
                                                @PathVariable String categoryId){
        return ResponseEntity.ok(exerciseService.save(payload, categoryId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        exerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
