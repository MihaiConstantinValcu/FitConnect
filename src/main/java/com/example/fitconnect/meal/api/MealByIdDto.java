package com.example.fitconnect.meal.api;

import com.example.fitconnect.meal.entity.MealType;
import com.example.fitconnect.meal_item.entity.MealItem;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MealByIdDto {
    private String id;
    @NotNull
    private LocalDate date;
    @NotNull
    private MealType mealType;
    private Set<MealItem> mealItems = new HashSet<>();
}
