package com.example.fitconnect.controller;

import com.example.fitconnect.category.api.CategoryByIdDto;
import com.example.fitconnect.category.controller.CategoryController;
import com.example.fitconnect.category.service.CategoryService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {
    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void addNewCategory(){
        CategoryByIdDto payload = new CategoryByIdDto();
        payload.setName("Weightlifting");

        when(categoryService.save(payload)).thenReturn(payload);

        ResponseEntity<CategoryByIdDto> response = categoryController.save(payload);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(payload.getName(), response.getBody().getName());
    }

}
