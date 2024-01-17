package com.example.fitconnect.meal.service;

import com.example.fitconnect.meal.api.MealByIdDto;
import com.example.fitconnect.meal_item.api.MealItemByIdDto;

import java.time.LocalDate;
import java.util.List;

public interface MealService {
    List<MealByIdDto> getAll();

    MealByIdDto getById(String id);

    MealByIdDto save(MealByIdDto payload);

    MealByIdDto addFood(String id, List<MealItemByIdDto> payload);

    List<MealByIdDto> getAllByDate(LocalDate date);
}
