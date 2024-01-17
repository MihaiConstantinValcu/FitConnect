package com.example.fitconnect.category.service;

import com.example.fitconnect.category.api.CategoryByIdDto;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;

import java.util.List;

public interface CategoryService {
    CategoryByIdDto getById(String id);

    CategoryByIdDto save(CategoryByIdDto payload);

    List<CategoryByIdDto> getAll();

    CategoryByIdDto addExercise(String id, List<ExerciseByIdDto> payload);

    CategoryByIdDto update(String id, CategoryByIdDto payload);
}
