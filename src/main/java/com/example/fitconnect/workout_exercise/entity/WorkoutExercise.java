package com.example.fitconnect.workout_exercise.entity;

import com.example.fitconnect.base_entity.BaseEntity;
import com.example.fitconnect.exercise.entity.Exercise;
import com.example.fitconnect.workout_session.entity.WorkoutSession;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class WorkoutExercise extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "workout_session_id")
    @JsonIgnore
    private WorkoutSession workoutSession;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private Integer repetitions;
    private Integer sets;
    private BigDecimal maxWeight;
}
