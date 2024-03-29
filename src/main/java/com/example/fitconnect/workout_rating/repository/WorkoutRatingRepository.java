package com.example.fitconnect.workout_rating.repository;

import com.example.fitconnect.workout_rating.entity.WorkoutRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRatingRepository extends JpaRepository<WorkoutRating, String> {

    List<WorkoutRating> findAllByWorkoutSessionId(String workoutSessionId);
}
