package com.example.fitconnect.exercise.ExerciseService;

import com.example.fitconnect.exercise.api.ExerciseByIdDto;

public interface ExerciseService {
    ExerciseByIdDto getById(String id);
}
