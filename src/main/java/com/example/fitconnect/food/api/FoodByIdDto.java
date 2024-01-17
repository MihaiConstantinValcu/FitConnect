package com.example.fitconnect.food.api;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FoodByIdDto {
    private String id;
    private String name;
    private BigDecimal calories;
    private BigDecimal proteins;
    private BigDecimal carbohydrates;
    private BigDecimal fats;
}
