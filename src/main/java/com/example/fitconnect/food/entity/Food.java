package com.example.fitconnect.food.entity;

import com.example.fitconnect.base_entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Food extends BaseEntity {
    private String name;
    private BigDecimal calories;
    private BigDecimal proteins;
    private BigDecimal carbohydrates;
    private BigDecimal fats;
}
