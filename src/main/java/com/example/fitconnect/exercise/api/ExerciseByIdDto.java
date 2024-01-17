package com.example.fitconnect.exercise.api;

import com.example.fitconnect.category.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseByIdDto {
    private String id;
    @NotNull
    private String name;
    private Category category;
}
