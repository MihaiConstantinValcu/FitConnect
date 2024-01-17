package com.example.fitconnect.workout_session.service;

import com.example.fitconnect.exercise.entity.Exercise;
import com.example.fitconnect.exercise.repository.ExerciseRepository;
import com.example.fitconnect.workout_exercise.api.WorkoutExerciseByIdDto;
import com.example.fitconnect.workout_exercise.entity.WorkoutExercise;
import com.example.fitconnect.workout_exercise.repository.WorkoutExerciseRepository;
import com.example.fitconnect.workout_session.api.WorkoutSessionByIdDto;
import com.example.fitconnect.workout_session.entity.WorkoutSession;
import com.example.fitconnect.workout_session.repository.WorkoutSessionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkoutSessionServiceImpl implements WorkoutSessionService {

    private final WorkoutSessionRepository workoutSessionRepository;
    private final ExerciseRepository exerciseRepository;
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final ModelMapper modelMapper;

    public WorkoutSessionServiceImpl(WorkoutSessionRepository workoutSessionRepository, ExerciseRepository exerciseRepository, WorkoutExerciseRepository workoutExerciseRepository, ModelMapper modelMapper) {
        this.workoutSessionRepository = workoutSessionRepository;
        this.exerciseRepository = exerciseRepository;
        this.workoutExerciseRepository = workoutExerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public WorkoutSessionByIdDto save(WorkoutSessionByIdDto payload) {
        WorkoutSession workoutSession = modelMapper.map(payload, WorkoutSession.class);
        workoutSession.setId(UUID.randomUUID().toString());

        return modelMapper.map(workoutSessionRepository.save(workoutSession), WorkoutSessionByIdDto.class);
    }

    @Override
    public WorkoutSessionByIdDto getById(String id) {
        return workoutSessionRepository.findById(id)
                .map(workoutSession -> modelMapper.map(workoutSession, WorkoutSessionByIdDto.class))
                .orElseThrow(() -> new RuntimeException("Workout Session not found"));
    }

    @Override
    public WorkoutSessionByIdDto addExercises(String id, List<WorkoutExerciseByIdDto> payload) {
        WorkoutSession workoutSession = workoutSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout Session not found"));

        List<WorkoutExercise> exercises = workoutSession.getExercises();

        payload.forEach(dto -> {
            Exercise exercise = exerciseRepository.findById(dto.getExerciseId())
                    .orElseThrow(() -> new RuntimeException("Exercise not found"));

            WorkoutExercise workoutExercise = modelMapper.map(dto, WorkoutExercise.class);
            workoutExercise.setWorkoutSession(workoutSession);
            workoutExercise.setExercise(exercise);
            workoutExercise.setId(UUID.randomUUID().toString());
            workoutExerciseRepository.save(workoutExercise);

            exercises.add(workoutExercise);
        });

        workoutSession.setExercises(exercises);
//        workoutSessionRepository.save(workoutSession);

        return modelMapper.map(workoutSession, WorkoutSessionByIdDto.class);
    }
}
