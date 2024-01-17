package com.example.fitconnect.food.service;

import com.example.fitconnect.food.api.FoodByIdDto;

import java.util.List;

public interface FoodService {
    List<FoodByIdDto> getAll();

    FoodByIdDto getById(String id);

    FoodByIdDto save(FoodByIdDto payload);

    FoodByIdDto update(String id, FoodByIdDto payload);
}
