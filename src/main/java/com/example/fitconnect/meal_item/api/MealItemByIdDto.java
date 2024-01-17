package com.example.fitconnect.meal_item.api;

import com.example.fitconnect.food.api.FoodByIdDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MealItemByIdDto {
    private FoodByIdDto food;
    private BigDecimal quantity;
}
