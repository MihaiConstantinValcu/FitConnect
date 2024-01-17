package com.example.fitconnect.category.api;

import com.example.fitconnect.exercise.entity.Exercise;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CategoryByIdDto {
    private String id;
    @NotNull
    private String name;
    private Set<Exercise> exercises = new HashSet<>();
}
