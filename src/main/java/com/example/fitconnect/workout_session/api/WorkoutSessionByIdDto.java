package com.example.fitconnect.workout_session.api;

import com.example.fitconnect.workout_exercise.entity.WorkoutExercise;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WorkoutSessionByIdDto {
    private String id;
    private LocalDate date;
    private Integer duration;
    private List<WorkoutExercise> exercises = new ArrayList<>();
}
