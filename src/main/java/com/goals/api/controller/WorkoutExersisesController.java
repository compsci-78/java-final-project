package com.goals.api.controller;

import com.goals.api.model.dto.Response;
import com.goals.api.service.WorkoutExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workoutexercises")
public class WorkoutExersisesController {
    @Autowired
    private WorkoutExerciseService exerciseService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>( new Response<>(true,"success",exerciseService.getAll()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        return new ResponseEntity<>( new Response<>(true,"success",exerciseService.get(id)), HttpStatus.OK);
    }

}
