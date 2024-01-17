package com.example.fitconnect.food.api;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class FoodValidator implements ConstraintValidator<ValidFood, FoodByIdDto> {
    @Override
    public void initialize(ValidFood constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(FoodByIdDto dto, ConstraintValidatorContext constraintValidatorContext) {
        BigDecimal proteins = dto.getProteins();
        BigDecimal carbohydrates = dto.getCarbohydrates();
        BigDecimal fats = dto.getFats();

        return proteins.add(carbohydrates).add(fats).equals(BigDecimal.valueOf(100));
    }
}
