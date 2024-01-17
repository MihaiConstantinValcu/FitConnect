package com.example.fitconnect.exercise.service;

import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface ExerciseService {
    ExerciseByIdDto getById(String id);

    ExerciseByIdDto save(ExerciseByIdDto payload);

    void delete(String id);

    List<ExerciseByIdDto> getAll();
}
