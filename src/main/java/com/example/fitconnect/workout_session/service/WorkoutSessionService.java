package com.example.fitconnect.workout_session.service;

import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import com.example.fitconnect.workout_exercise.api.WorkoutExerciseByIdDto;
import com.example.fitconnect.workout_session.api.WorkoutSessionByIdDto;

import java.util.List;

public interface WorkoutSessionService {
    WorkoutSessionByIdDto save(WorkoutSessionByIdDto payload);

    WorkoutSessionByIdDto getById(String id);

    WorkoutSessionByIdDto addExercises(String id, List<WorkoutExerciseByIdDto> payload);

    List<WorkoutSessionByIdDto> getAll();
}
