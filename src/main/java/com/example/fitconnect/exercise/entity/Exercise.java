package com.example.fitconnect.exercise;

import com.example.fitconnect.base_entity.BaseEntity;
import com.example.fitconnect.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Exercise extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
