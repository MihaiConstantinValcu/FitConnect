package com.example.fitconnect.meal.controller;

import com.example.fitconnect.food.api.FoodByIdDto;
import com.example.fitconnect.meal.api.MealByIdDto;
import com.example.fitconnect.meal.service.MealService;
import com.example.fitconnect.meal_item.api.MealItemByIdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.example.fitconnect.meal.controller.MealController.MEAL_URL;

@RestController
@RequestMapping(MEAL_URL)
public class MealController {
    public final static String MEAL_URL = "/meals";

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @Operation(summary = "Get all meals")
    @GetMapping
    public ResponseEntity<List<MealByIdDto>> getAll(){
        return ResponseEntity.ok(mealService.getAll());
    }

    @Operation(summary = "Get all meals by a specific date")
    @GetMapping
    public ResponseEntity<List<MealByIdDto>> getAllByDate(@RequestParam LocalDate date){
        return ResponseEntity.ok(mealService.getAllByDate(date));
    }

    @Operation(summary = "Get meal based on specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Meal information was successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "The Meal with the provided ID doesn't exist")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MealByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(mealService.getById(id));
    }

    @Operation(summary = "Add new meal",
            description = "Adds a new meal based on the information received in the request")
    @Parameter(name = "payload", description = "Meal details", required = true)
    @PostMapping
    public ResponseEntity<MealByIdDto> save(@RequestBody MealByIdDto payload){
        return ResponseEntity.ok(mealService.save(payload));
    }

    @Operation(summary = "Add a meal item to the meal",
            description = "Meal items consists of a food item and a quantity")
    @Parameter(name = "payload", description = "Meal Item details", required = true)
    @PatchMapping("/{id}/add-food")
    public ResponseEntity<MealByIdDto> addFood(@PathVariable String id, @RequestBody List<MealItemByIdDto> payload){
        return ResponseEntity.ok(mealService.addFood(id, payload));
    }
}
