package com.example.fitconnect.controller;

import com.example.fitconnect.exercise.controller.ExerciseController;
import com.example.fitconnect.exercise.service.ExerciseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class ExerciseControllerTest {

    @InjectMocks
    private ExerciseController exerciseController;

    @Mock
    private ExerciseServiceImpl exerciseService;

    @Test
    public void deleteExercise_statusNoContent() {
        String id = "test";

        ResponseEntity<Void> response = exerciseController.delete(id);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

}
