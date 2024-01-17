package com.example.fitconnect.exercise.exercise_repository;

import com.example.fitconnect.exercise.Exercise;
import com.example.fitconnect.ExerciseCategory.ExerciseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, String> {

    Optional<Exercise> findByCategory(ExerciseCategory category);
}
