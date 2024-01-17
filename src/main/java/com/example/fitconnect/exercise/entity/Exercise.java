package com.example.fitconnect.exercise.entity;

import com.example.fitconnect.base_entity.BaseEntity;
import com.example.fitconnect.category.entity.Category;
import com.example.fitconnect.workout_exercise.entity.WorkoutExercise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Exercise extends BaseEntity {
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.REMOVE)
    private List<WorkoutExercise> workoutExercises;
}
