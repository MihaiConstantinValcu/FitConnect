package com.example.fitconnect.controller;

import com.example.fitconnect.meal.api.MealByIdDto;
import com.example.fitconnect.meal.controller.MealController;
import com.example.fitconnect.meal.service.MealServiceImpl;
import com.example.fitconnect.meal_item.api.MealItemByIdDto;
import com.example.fitconnect.meal_item.entity.MealItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MealControllerTest {
    @InjectMocks
    private MealController mealController;

    @Mock
    private MealServiceImpl mealService;

    @Test
    public void getAllByDate_checkSize(){
        LocalDate date = LocalDate.now();

        List<MealByIdDto> meals = new ArrayList<>();
        MealByIdDto meal = new MealByIdDto();
        meal.setDate(date);
        meals.add(meal);

        when(mealService.getAllByDate(date)).thenReturn(meals);

        ResponseEntity<List<MealByIdDto>> response = mealController.getAllByDate(LocalDate.now());

        Assertions.assertEquals(meals.size(), response.getBody().size());
    }

    @Test
    public void addFood_checkStatus(){
        String id = "mealTest";
        List<MealItemByIdDto> payload = new ArrayList<>();
        payload.add(new MealItemByIdDto());

        MealByIdDto object = new MealByIdDto();
        Set<MealItem> mealItems = new HashSet<>();
        mealItems.add(new MealItem());
        object.setMealItems(mealItems);

        when(mealService.addFood(id, payload)).thenReturn(object);

        ResponseEntity<MealByIdDto> response = mealController.addFood(id, payload);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
