package com.example.fitconnect.exercise.api;

import com.example.fitconnect.category.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseByIdDto {
    private String id;
    private String name;
    private Category category;
}
