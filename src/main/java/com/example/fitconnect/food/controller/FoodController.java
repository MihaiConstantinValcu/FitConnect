package com.example.fitconnect.food.controller;

import com.example.fitconnect.food.api.FoodByIdDto;
import com.example.fitconnect.food.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.fitconnect.food.controller.FoodController.FOOD_URL;

@RestController
@RequestMapping(FOOD_URL)
public class FoodController {
    public final static String FOOD_URL = "/foods";

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @Operation(summary = "Get all foods")
    @GetMapping
    public ResponseEntity<List<FoodByIdDto>> getAll(){
        return ResponseEntity.ok(foodService.getAll());
    }

    @Operation(summary = "Get food based on specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Food information was successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "The Food with the provided ID doesn't exist")
    })
    @Parameter(name = "id", description = "Food ID", required = true)
    @GetMapping("/{id}")
    public ResponseEntity<FoodByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(foodService.getById(id));
    }

    @Operation(summary = "Add new food",
            description = "Adds a new food type based on the information received in the request")
    @Parameter(name = "payload", description = "Food details", required = true)
    @PostMapping
    public ResponseEntity<FoodByIdDto> save(@RequestBody @Valid FoodByIdDto payload){
        return ResponseEntity.ok(foodService.save(payload));
    }

    @Operation(summary = "Update food details",
            description = "Updates a food based on the information received in the request")
    @Parameter(name = "payload", description = "The new details of food", required = true)
    @Parameter(name = "id", description = "Food Id", required = true)
    @PatchMapping("/{id}")
    public ResponseEntity<FoodByIdDto> update(@PathVariable String id,
                                              @RequestBody @Valid FoodByIdDto payload){
        return ResponseEntity.ok(foodService.update(id, payload));
    }
}
