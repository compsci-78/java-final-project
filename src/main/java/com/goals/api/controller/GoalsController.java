package com.goals.api.controller;

import com.goals.api.model.Goal;
import com.goals.api.model.dto.Response;
import com.goals.api.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goals")
public class GoalsController {
    @Autowired
    private GoalService goalService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<Goal> goals = goalService.getAll();
        return new ResponseEntity<>(new Response<>(true,"success",goals), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        return new ResponseEntity<>(new Response<>(true,"success",goalService.get(id)), HttpStatus.OK);
    }
}
