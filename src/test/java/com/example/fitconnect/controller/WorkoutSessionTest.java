package com.example.fitconnect.controller;

import com.example.fitconnect.category.api.CategoryByIdDto;
import com.example.fitconnect.workout_session.api.WorkoutSessionByIdDto;
import com.example.fitconnect.workout_session.controller.WorkoutSessionController;
import com.example.fitconnect.workout_session.service.WorkoutSessionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WorkoutSessionTest {
    @InjectMocks
    private WorkoutSessionController workoutSessionController;

    @Mock
    private WorkoutSessionServiceImpl workoutSessionService;

    @Test
    public void getAll_checkId_andSize_andStatusCode(){
        List<WorkoutSessionByIdDto> workouts = new ArrayList<>();
        WorkoutSessionByIdDto workout = new WorkoutSessionByIdDto();
        workout.setId("test");
        workouts.add(workout);

        when(workoutSessionService.getAll()).thenReturn(workouts);

        ResponseEntity<List<WorkoutSessionByIdDto>> response = workoutSessionController.getAll();

        Assertions.assertEquals(workouts.get(0).getId(), response.getBody().get(0).getId());
        Assertions.assertEquals(workouts.size(), response.getBody().size());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
