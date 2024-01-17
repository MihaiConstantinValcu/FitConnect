package com.example.fitconnect.food.service;

import com.example.fitconnect.food.api.FoodByIdDto;
import com.example.fitconnect.food.entity.Food;
import com.example.fitconnect.food.repository.FoodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService{

    private final FoodRepository foodRepository;
    private final ModelMapper modelMapper;

    public FoodServiceImpl(FoodRepository foodRepository, ModelMapper modelMapper) {
        this.foodRepository = foodRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FoodByIdDto> getAll() {
        return foodRepository.findAll().stream()
                .map(food -> modelMapper.map(food, FoodByIdDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FoodByIdDto getById(String id) {
        return foodRepository.findById(id)
                .map(food -> modelMapper.map(food, FoodByIdDto.class))
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    @Override
    public FoodByIdDto save(FoodByIdDto payload) {
        Food food = modelMapper.map(payload, Food.class);
        food.setId(UUID.randomUUID().toString());
        foodRepository.save(food);

        return modelMapper.map(food, FoodByIdDto.class);
    }

    @Override
    public FoodByIdDto update(String id, FoodByIdDto payload) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        Food newFood = modelMapper.map(payload, Food.class);
        newFood.setId(food.getId());
        foodRepository.save(newFood);

        return modelMapper.map(newFood, FoodByIdDto.class);
    }
}
