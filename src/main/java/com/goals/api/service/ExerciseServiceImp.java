package com.goals.api.service;

import com.goals.api.model.Exercise;
import com.goals.api.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExerciseServiceImp implements ExerciseService{
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Override
    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise get(Integer id) {
        return exerciseRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No exercise matches the provided id"));
    }

    @Override
    public Exercise create(Exercise entity) {
        return null;
    }

    @Override
    public Exercise update(Integer id, Exercise entity) {
        return null;
    }

    @Override
    public Exercise delete(Integer id) {
        return null;
    }
}
