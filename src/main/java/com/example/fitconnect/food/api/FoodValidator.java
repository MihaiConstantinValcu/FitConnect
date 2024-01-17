package com.example.fitconnect.food.api;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import java.math.BigDecimal;

public class FoodValidator implements ConstraintValidator<ValidFood, FoodByIdDto> {
    @Override
    public void initialize(ValidFood constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(FoodByIdDto dto, ConstraintValidatorContext context) {
        BigDecimal proteins = dto.getProteins();
        BigDecimal carbohydrates = dto.getCarbohydrates();
        BigDecimal fats = dto.getFats();

        if(proteins.add(carbohydrates).add(fats).compareTo(new BigDecimal(100)) > 0){
            ((ConstraintValidatorContextImpl) context)
                    .buildConstraintViolationWithTemplate("Sum of values must be less or equal to 100")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }
        return true;
    }

}
