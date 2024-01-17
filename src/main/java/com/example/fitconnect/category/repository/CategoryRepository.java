package com.example.fitconnect.exercise_category.repository;

import com.example.fitconnect.exercise_category.ExerciseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategory, String> {
}
