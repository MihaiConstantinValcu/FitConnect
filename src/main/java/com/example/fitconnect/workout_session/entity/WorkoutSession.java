package com.example.fitconnect.workout_session.entity;

import com.example.fitconnect.base_entity.BaseEntity;
import com.example.fitconnect.workout_exercise.entity.WorkoutExercise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class WorkoutSession extends BaseEntity {
    private LocalDate localDate;
    private Integer duration;

    @OneToMany(mappedBy = "workoutSession")
    @JsonIgnore
    private List<WorkoutExercise> exercises = new ArrayList<>();
}
