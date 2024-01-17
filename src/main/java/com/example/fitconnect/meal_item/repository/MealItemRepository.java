package com.example.fitconnect.meal_item.repository;

import com.example.fitconnect.meal_item.entity.MealItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealItemRepository extends JpaRepository<MealItem, String> {
}
