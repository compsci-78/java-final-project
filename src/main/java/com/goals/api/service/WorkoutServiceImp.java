package com.goals.api.service;

import com.goals.api.model.Workout;
import com.goals.api.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class WorkoutServiceImp implements WorkoutService{
    @Autowired
    private WorkoutRepository workoutRepository;
    @Override
    public List<Workout> getAll() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout get(Integer id) {
        return workoutRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No workout matches the provided id"));
    }

    @Override
    public Workout create(Workout entity) {
        return null;
    }

    @Override
    public Workout update(Integer id, Workout entity) {
        return null;
    }

    @Override
    public Workout delete(Integer id) {
        return null;
    }
}
