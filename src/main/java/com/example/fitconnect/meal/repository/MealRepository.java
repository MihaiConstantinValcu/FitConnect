package com.example.fitconnect.meal.repository;

import com.example.fitconnect.meal.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, String> {
    List<Meal> findAllByDate(LocalDate date);
}
