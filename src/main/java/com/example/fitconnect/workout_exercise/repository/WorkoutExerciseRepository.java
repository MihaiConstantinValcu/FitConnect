package com.example.fitconnect.workout_exercise.repository;

import com.example.fitconnect.workout_exercise.entity.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, String> {

}
