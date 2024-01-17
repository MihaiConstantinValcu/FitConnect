package com.example.fitconnect.controller;

import com.example.fitconnect.food.api.FoodByIdDto;
import com.example.fitconnect.food.controller.FoodController;
import com.example.fitconnect.food.service.FoodServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FoodControllerTest {
    @InjectMocks
    private FoodController foodController;

    @Mock
    private FoodServiceImpl foodService;

    @Test
    public void updateFood_statusOk(){
        FoodByIdDto payload = new FoodByIdDto();
        payload.setProteins(new BigDecimal(90));

        when(foodService.update("test", payload)).thenReturn(payload);

        ResponseEntity<FoodByIdDto> response = foodController.update("test", payload);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
