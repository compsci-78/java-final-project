package com.goals.api.service;

import com.goals.api.model.WorkoutExercise;
import com.goals.api.repository.WorkoutExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class WorkoutExerciseServiceImp implements WorkoutExerciseService{
    @Autowired
    private WorkoutExerciseRepository workoutExerciseRepository;

    @Override
    public List<WorkoutExercise> getAll() {
        return workoutExerciseRepository.findAll();
    }

    @Override
    public WorkoutExercise get(Integer id) {
        return workoutExerciseRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No workoutExercise matches provided id"));
    }

    @Override
    public WorkoutExercise create(WorkoutExercise entity) {
        return null;
    }

    @Override
    public WorkoutExercise update(Integer id, WorkoutExercise entity) {
        return null;
    }

    @Override
    public WorkoutExercise delete(Integer id) {
        return null;
    }
}
