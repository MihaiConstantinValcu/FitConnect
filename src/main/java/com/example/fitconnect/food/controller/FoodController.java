package com.example.fitconnect.food.controller;

import com.example.fitconnect.food.api.FoodByIdDto;
import com.example.fitconnect.food.service.FoodService;
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

    @GetMapping
    public ResponseEntity<List<FoodByIdDto>> getAll(){
        return ResponseEntity.ok(foodService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodByIdDto> getById(@PathVariable String id){
        return ResponseEntity.ok(foodService.getById(id));
    }

    @PostMapping
    public ResponseEntity<FoodByIdDto> save(@RequestBody FoodByIdDto payload){
        return ResponseEntity.ok(foodService.save(payload));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FoodByIdDto> update(@PathVariable String id,
                                              @RequestBody FoodByIdDto payload){
        return ResponseEntity.ok(foodService.update(id, payload));
    }
}
