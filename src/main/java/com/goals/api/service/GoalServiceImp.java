package com.goals.api.service;

import com.goals.api.model.Goal;
import com.goals.api.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class GoalServiceImp implements GoalService{
    @Autowired
    private GoalRepository goalRepository;
    @Override
    public List<Goal> getAll() {
        return goalRepository.findAll();
    }

    @Override
    public Goal get(Integer id) {
        return  goalRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No goal matches the provided id"));
    }

    @Override
    public Goal create(Goal entity) {
        return null;
    }

    @Override
    public Goal update(Integer id, Goal entity) {
        return null;
    }

    @Override
    public Goal delete(Integer id) {
        return null;
    }
}
