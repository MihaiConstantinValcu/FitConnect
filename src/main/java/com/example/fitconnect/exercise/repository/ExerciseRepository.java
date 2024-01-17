package com.example.fitconnect.exercise.repository;

import com.example.fitconnect.exercise.entity.Exercise;
import com.example.fitconnect.category.entity.Category;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
    Optional<Exercise> findByCategory(Category category);
    void deleteById(@NotNull String id);
}
