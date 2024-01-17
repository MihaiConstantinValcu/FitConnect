package com.example.fitconnect.exercise_category.service;

import com.example.fitconnect.exercise_category.api.ExerciseCategoryByIdDto;

public interface ExerciseCategoryService {
    ExerciseCategoryByIdDto getById(String id);

    ExerciseCategoryByIdDto save(ExerciseCategoryByIdDto payload);
}
