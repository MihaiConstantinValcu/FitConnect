package com.example.fitconnect.exercise_category.service;

import com.example.fitconnect.exercise.Exercise;
import com.example.fitconnect.exercise.service.ExerciseService;
import com.example.fitconnect.exercise_category.ExerciseCategory;
import com.example.fitconnect.exercise_category.api.ExerciseCategoryByIdDto;
import com.example.fitconnect.exercise_category.repository.ExerciseCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class ExerciseCategoryServiceImpl implements ExerciseCategoryService{

    private final ExerciseCategoryRepository exerciseCategoryRepository;
    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    public ExerciseCategoryServiceImpl(ExerciseCategoryRepository exerciseCategoryRepository, ExerciseService exerciseService, ModelMapper modelMapper) {
        this.exerciseCategoryRepository = exerciseCategoryRepository;
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ExerciseCategoryByIdDto getById(String id) {
        return null;
    }

    @Override
    public ExerciseCategoryByIdDto save(ExerciseCategoryByIdDto payload) {
//        ExerciseCategory exerciseCategory = new ExerciseCategory();
//        String id = UUID.randomUUID().toString();
//
//        Set<Exercise> exercises = new HashSet<>();
//
//        payload.getExercises().forEach(exerciseDto -> {
//            Exercise exercise = modelMapper.map(exerciseService.save(exerciseDto), Exercise.class);
//            exercises.add(exercise);
//            exerciseDto.setId(exercise.getId());
//        });
//
//        modelMapper.map(payload, exerciseCategory);
//        exerciseCategory.setId(id);
//
//        exerciseCategory.setExercises(exercises);
//        exerciseCategoryRepository.save(exerciseCategory);
//        payload.setId(exerciseCategory.getId());
//
//        return payload;
    }
}
