package com.example.fitconnect.category.controller;

import com.example.fitconnect.category.api.CategoryByIdDto;
import com.example.fitconnect.category.service.CategoryService;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary = "Get category based on specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Category information was successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "The Category with the provided ID doesn't exist")
    })
    @Parameter(name = "id", description = "Category ID", required = true)
    @GetMapping("/{id}")
    public ResponseEntity<CategoryByIdDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @Operation(summary = "Get all categories")
    @GetMapping("/list")
    public ResponseEntity<List<CategoryByIdDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @Operation(summary = "Create a category",
            description = "Creates a new category based on the information received in the request")
    @Parameter(name = "payload", description = "Category details", required = true)
    @PostMapping
    public ResponseEntity<CategoryByIdDto> save(@RequestBody @Valid CategoryByIdDto payload) {
        return ResponseEntity.ok(categoryService.save(payload));
    }

    @Operation(summary = "Update category details",
            description = "Updates a category based on the information received in the request")
    @Parameter(name = "payload", description = "The new details of category", required = true)
    @Parameter(name = "id", description = "Category Id", required = true)
    @PatchMapping("/{id}")
    public ResponseEntity<CategoryByIdDto> update(@PathVariable String id,
                                                  @RequestBody @Valid CategoryByIdDto payload) {
        return ResponseEntity.ok(categoryService.update(id, payload));
    }

    @Operation(summary = "Add exercise to category",
            description = "Adds a new exercise to category")
    @Parameter(name = "payload", description = "A list of exercises to be added to category", required = true)
    @Parameter(name = "id", description = "Category ID", required = true)
    @PatchMapping("/{id}/add-exercise")
    public ResponseEntity<CategoryByIdDto> addExercise(@PathVariable String id,
                                                       @RequestBody @Valid List<ExerciseByIdDto> payload) {
        return ResponseEntity.ok(categoryService.addExercise(id, payload));
    }
}
