package com.goals.api.service;

import com.goals.api.model.GoalWorkout;
import com.goals.api.repository.GoalWorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class GoalWorkoutServiceImp implements GoalWorkoutService{
    @Autowired
    private GoalWorkoutRepository goalWorkoutRepository;
    @Override
    public List<GoalWorkout> getAll() {
        return goalWorkoutRepository.findAll();
    }

    @Override
    public GoalWorkout get(Integer id) {
        return goalWorkoutRepository.findById(id)
                .orElseThrow((()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"No goalWorkout matches provided id")));
    }

    @Override
    public GoalWorkout create(GoalWorkout entity) {
        return null;
    }

    @Override
    public GoalWorkout update(Integer id, GoalWorkout entity) {
        return null;
    }

    @Override
    public GoalWorkout delete(Integer id) {
        return null;
    }
}
