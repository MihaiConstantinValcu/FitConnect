package com.example.fitconnect.meal.controller;

import com.example.fitconnect.food.api.FoodByIdDto;
import com.example.fitconnect.meal.api.MealByIdDto;
import com.example.fitconnect.meal.service.MealService;
import com.example.fitconnect.meal_item.api.MealItemByIdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<MealByIdDto>> getAll(){
        return ResponseEntity.ok(mealService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(mealService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MealByIdDto> save(@RequestBody MealByIdDto payload){
        return ResponseEntity.ok(mealService.save(payload));
    }

    @PatchMapping("/{id}/add-food")
    public ResponseEntity<MealByIdDto> addFood(@PathVariable String id, @RequestBody List<MealItemByIdDto> payload){
        return ResponseEntity.ok(mealService.addFood(id, payload));
    }
}
