package com.example.fitconnect.category.controller;

import com.example.fitconnect.category.api.CategoryByIdDto;
import com.example.fitconnect.category.service.CategoryService;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.fitconnect.category.controller.CategoryController.EXERCISE_CATEGORY_URL;

@RestController
@RequestMapping(EXERCISE_CATEGORY_URL)
public class CategoryController {

    public final static String EXERCISE_CATEGORY_URL = "/categories";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryByIdDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoryByIdDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping
    public ResponseEntity<CategoryByIdDto> save(@RequestBody CategoryByIdDto payload) {
        return ResponseEntity.ok(categoryService.save(payload));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryByIdDto> update(@PathVariable String id,
                                                  @RequestBody CategoryByIdDto payload) {
        return ResponseEntity.ok(categoryService.update(id, payload));
    }

    @PatchMapping("/{id}/add-exercise")
    public ResponseEntity<CategoryByIdDto> addExercise(@PathVariable String id,
                                                       @RequestBody List<ExerciseByIdDto> payload) {
        return ResponseEntity.ok(categoryService.addExercise(id, payload));
    }
}
