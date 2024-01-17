package com.example.fitconnect.meal_item.entity;

import com.example.fitconnect.base_entity.BaseEntity;
import com.example.fitconnect.food.entity.Food;
import com.example.fitconnect.meal.entity.Meal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class MealItem extends BaseEntity {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private BigDecimal quantity;
}
