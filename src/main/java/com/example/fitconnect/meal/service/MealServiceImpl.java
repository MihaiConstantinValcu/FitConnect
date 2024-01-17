package com.example.fitconnect.meal.service;

import com.example.fitconnect.food.entity.Food;
import com.example.fitconnect.food.repository.FoodRepository;
import com.example.fitconnect.meal.api.MealByIdDto;
import com.example.fitconnect.meal.entity.Meal;
import com.example.fitconnect.meal.repository.MealRepository;
import com.example.fitconnect.meal_item.api.MealItemByIdDto;
import com.example.fitconnect.meal_item.entity.MealItem;
import com.example.fitconnect.meal_item.repository.MealItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService{

    private final MealRepository mealRepository;
    private final FoodRepository foodRepository;
    private final MealItemRepository mealItemRepository;
    private final ModelMapper modelMapper;

    public MealServiceImpl(MealRepository mealRepository, FoodRepository foodRepository, MealItemRepository mealItemRepository, ModelMapper modelMapper) {
        this.mealRepository = mealRepository;
        this.foodRepository = foodRepository;
        this.mealItemRepository = mealItemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MealByIdDto> getAll() {
        return mealRepository.findAll().stream()
                .map(meal -> modelMapper.map(meal, MealByIdDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MealByIdDto getById(String id) {
        return mealRepository.findById(id)
                .map(meal -> modelMapper.map(meal, MealByIdDto.class))
                .orElseThrow(() -> new RuntimeException("Meal does not exist"));
    }

    @Override
    public MealByIdDto save(MealByIdDto payload) {
        Meal meal = modelMapper.map(payload, Meal.class);
        meal.setId(UUID.randomUUID().toString());

        mealRepository.save(meal);

        return modelMapper.map(meal, MealByIdDto.class);
    }

    @Override
    public MealByIdDto addFood(String id, List<MealItemByIdDto> payload) {
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal does not exist"));

        Set<MealItem> mealItems = meal.getMealItems();

        payload.forEach(dto -> {
            Food food = foodRepository.findById(dto.getFood().getId())
                    .orElseThrow(() -> new RuntimeException("Food does not exist"));

            MealItem mealItem = new MealItem();
            mealItem.setId(UUID.randomUUID().toString());
            mealItem.setMeal(meal);
            mealItem.setFood(food);
            mealItem.setQuantity(dto.getQuantity());

            mealItems.add(mealItem);
        });

        mealItemRepository.saveAll(mealItems);

        meal.setMealItems(mealItems);
        mealRepository.save(meal);

        return modelMapper.map(meal, MealByIdDto.class);
    }
}
