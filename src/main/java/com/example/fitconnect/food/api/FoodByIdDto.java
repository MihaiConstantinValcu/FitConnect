package com.example.fitconnect.food.api;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@ValidFood
public class FoodByIdDto {
    private String id;
    @NotNull
    private String name;
    private BigDecimal calories;
    private BigDecimal proteins = BigDecimal.ZERO;
    private BigDecimal carbohydrates = BigDecimal.ZERO;
    private BigDecimal fats = BigDecimal.ZERO;
}
