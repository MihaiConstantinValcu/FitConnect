package com.example.fitconnect.workout_rating.entity;

import com.example.fitconnect.base_entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class WorkoutRating extends BaseEntity {
    private Integer rating;
    private String comment;
    private String workoutSessionId;
}
