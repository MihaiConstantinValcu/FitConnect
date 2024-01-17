package com.example.fitconnect.exercise.ExerciseService;

import com.example.fitconnect.exercise.Exercise;
import com.example.fitconnect.exercise.exercise_repository.ExerciseRepository;
import com.example.fitconnect.exercise.api.ExerciseByIdDto;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ExerciseByIdDto getById(String id) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
        if(exerciseOptional.isEmpty()){
            throw new EntityNotFoundException(String.format("Exercise with id %s not found", id));
        }
        Exercise exercise = exerciseOptional.get();

        return modelMapper.map(exercise, ExerciseByIdDto.class);
    }
}
