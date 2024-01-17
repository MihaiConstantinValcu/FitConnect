package com.example.fitconnect.exercise.service;

import com.example.fitconnect.category.entity.Category;
import com.example.fitconnect.category.service.CategoryService;
import com.example.fitconnect.exercise.entity.Exercise;
import com.example.fitconnect.exercise.repository.ExerciseRepository;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import com.example.fitconnect.workout_exercise.repository.WorkoutExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final CategoryService categoryService;
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, CategoryService categoryService, WorkoutExerciseRepository workoutExerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.categoryService = categoryService;
        this.workoutExerciseRepository = workoutExerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ExerciseByIdDto getById(String id) {
        return exerciseRepository.findById(id)
                .map(exercise -> modelMapper.map(exercise, ExerciseByIdDto.class))
                .orElseThrow(() -> new EntityNotFoundException(String.format("Exercise with id %s not found", id)));
    }

    @Override
    public ExerciseByIdDto save(ExerciseByIdDto payload, String categoryId) {
        Exercise exercise = modelMapper.map(payload, Exercise.class);
        exercise.setId(UUID.randomUUID().toString());

        Category category = modelMapper.map(categoryService.getById(categoryId), Category.class);

        exercise.setCategory(category);
        exerciseRepository.save(exercise);

        return modelMapper.map(exercise, ExerciseByIdDto.class);
    }

    @Override
    public void delete(String id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    public List<ExerciseByIdDto> getAll() {
        return exerciseRepository.findAll()
                .stream().map(exercise -> modelMapper.map(exercise, ExerciseByIdDto.class))
                .collect(Collectors.toList());
    }
}
