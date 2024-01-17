package com.example.fitconnect.category.service;

import com.example.fitconnect.category.entity.Category;
import com.example.fitconnect.category.api.CategoryByIdDto;
import com.example.fitconnect.category.repository.CategoryRepository;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import com.example.fitconnect.exercise.entity.Exercise;
import com.example.fitconnect.exercise.repository.ExerciseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryByIdDto getById(String id) {
        return categoryRepository.findById(id)
                .map(category -> modelMapper.map(category, CategoryByIdDto.class))
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public CategoryByIdDto save(CategoryByIdDto payload) {
        Category category = modelMapper.map(payload, Category.class);
        category.setId(UUID.randomUUID().toString());

        return modelMapper.map(categoryRepository.save(category), CategoryByIdDto.class);
    }

    @Override
    public List<CategoryByIdDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryByIdDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryByIdDto addExercise(String id, List<ExerciseByIdDto> payload) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Set<Exercise> exercises = category.getExercises();

        payload.forEach(dto -> {
            Exercise exercise = exerciseRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Exercise not found"));
            exercise.setCategory(category);
            exerciseRepository.save(exercise);

            exercises.add(exercise);
        });

        category.setExercises(exercises);
        categoryRepository.save(category);

        return modelMapper.map(category, CategoryByIdDto.class);
    }

    @Override
    public CategoryByIdDto update(String id, CategoryByIdDto payload) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(payload.getName());
        categoryRepository.save(category);

        return modelMapper.map(category, CategoryByIdDto.class);
    }
}
