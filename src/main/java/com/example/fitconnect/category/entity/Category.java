package com.example.fitconnect.category.entity;

import com.example.fitconnect.base_entity.BaseEntity;
import com.example.fitconnect.exercise.entity.Exercise;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Exercise> exercises;
}
