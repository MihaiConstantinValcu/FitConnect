package com.example.fitconnect.category;

import com.example.fitconnect.base_entity.BaseEntity;
import com.example.fitconnect.exercise.Exercise;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Exercise> exercises;
}
