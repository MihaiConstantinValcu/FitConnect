package com.example.fitconnect.workout_rating.service;

import com.example.fitconnect.workout_rating.api.WorkoutRatingByIdDto;
import com.example.fitconnect.workout_rating.entity.WorkoutRating;
import com.example.fitconnect.workout_rating.repository.WorkoutRatingRepository;
import com.example.fitconnect.workout_session.entity.WorkoutSession;
import com.example.fitconnect.workout_session.repository.WorkoutSessionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WorkoutRatingServiceImpl implements WorkoutRatingService{
    private final WorkoutRatingRepository workoutRatingRepository;
    private final WorkoutSessionRepository workoutSessionRepository;
    private final ModelMapper modelMapper;

    public WorkoutRatingServiceImpl(WorkoutRatingRepository workoutRatingRepository, WorkoutSessionRepository workoutSessionRepository, ModelMapper modelMapper) {
        this.workoutRatingRepository = workoutRatingRepository;
        this.workoutSessionRepository = workoutSessionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<WorkoutRatingByIdDto> getAllByWorkoutId(String id) {
        return workoutRatingRepository.findAllByWorkoutSessionId(id).stream()
                .map(rating -> modelMapper.map(rating, WorkoutRatingByIdDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public WorkoutRatingByIdDto save(String id, WorkoutRatingByIdDto payload) {
        WorkoutSession workoutSession = workoutSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout Session not found"));

        WorkoutRating rating = modelMapper.map(payload, WorkoutRating.class);
        rating.setId(UUID.randomUUID().toString());
        rating.setWorkoutSessionId(id);

        workoutRatingRepository.save(rating);
        return modelMapper.map(rating, WorkoutRatingByIdDto.class);
    }
}
