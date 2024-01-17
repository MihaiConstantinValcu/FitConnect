package com.example.fitconnect.workout_session.repository;

import com.example.fitconnect.workout_session.entity.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, String> {
}
