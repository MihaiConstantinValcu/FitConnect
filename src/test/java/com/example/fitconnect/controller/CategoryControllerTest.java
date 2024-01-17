package com.example.fitconnect.controller;

import com.example.fitconnect.category.api.CategoryByIdDto;
import com.example.fitconnect.category.controller.CategoryController;
import com.example.fitconnect.category.service.CategoryServiceImpl;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import com.example.fitconnect.exercise.entity.Exercise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {
    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryServiceImpl categoryService;

    @Test
    public void addNewCategory_responseOk() {
        CategoryByIdDto payload = new CategoryByIdDto();
        payload.setName("Weightlifting");

        CategoryByIdDto object = new CategoryByIdDto();
        object.setName("Weightlifting");

        when(categoryService.save(payload)).thenReturn(object);

        ResponseEntity<CategoryByIdDto> response = categoryController.save(payload);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getCategoryById_checkId(){
        CategoryByIdDto object = new CategoryByIdDto();
        object.setId("test");

        when(categoryService.getById(object.getId())).thenReturn(object);

        ResponseEntity<CategoryByIdDto> response = categoryController.getById("test");

        Assertions.assertEquals(object.getId(), response.getBody().getId());
    }

    @Test
    public void getAll_checkId_andSize(){
        List<CategoryByIdDto> categories = new ArrayList<>();
        CategoryByIdDto category = new CategoryByIdDto();
        category.setId("test");
        categories.add(category);

        when(categoryService.getAll()).thenReturn(categories);

        ResponseEntity<List<CategoryByIdDto>> response = categoryController.getAll();

        Assertions.assertEquals(categories.get(0).getId(), response.getBody().get(0).getId());
        Assertions.assertEquals(categories.size(), response.getBody().size());
    }

    @Test
    public void addExercise_checkSetSize(){
        List<ExerciseByIdDto> payload = new ArrayList<>();
        payload.add(new ExerciseByIdDto());

        Set<Exercise> exercises = new HashSet<>();
        exercises.add(new Exercise());

        CategoryByIdDto object = new CategoryByIdDto();
        object.setExercises(exercises);

        when(categoryService.addExercise("test", payload)).thenReturn(object);

        ResponseEntity<CategoryByIdDto> response = categoryController.addExercise("test", payload);

        Assertions.assertEquals(object.getExercises().size(), response.getBody().getExercises().size());
    }





}
