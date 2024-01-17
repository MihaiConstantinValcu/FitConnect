package com.example.fitconnect.meal.entity;

import com.example.fitconnect.base_entity.BaseEntity;
import com.example.fitconnect.meal_item.entity.MealItem;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Meal extends BaseEntity {
    private LocalDate date;

    @Enumerated(value = EnumType.STRING)
    private MealType mealType;

    @OneToMany(mappedBy = "meal")
    private Set<MealItem> mealItems = new HashSet<>();
}
