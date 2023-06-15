package com.goals.api.controller;

import com.goals.api.model.Goal;
import com.goals.api.model.GoalWorkout;
import com.goals.api.model.Workout;
import com.goals.api.model.dto.*;
import com.goals.api.service.GoalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goals")
public class GoalsController {
    @Autowired
    private GoalService goalService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(
                new Response<>(true,"success",goalService.getAll()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        return new ResponseEntity<>(
                new Response<>(true,"success",goalService.get(id)), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid CreateGoalDto createGoalDto){

        Goal createdGoal = goalService.create(createGoalDto);

        return new ResponseEntity<>(new Response<>(true,"success", new ReadGoalDto(
                createdGoal.getId(),
                createdGoal.getStatus(),
                createdGoal.getStartsAt(),
                createdGoal.getEndsAt())), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody @Valid UpdateGoalDto updateGoalDto){

        Goal updatedGoal = goalService.update(id,updateGoalDto);

        return new ResponseEntity<>(new Response<>(true,"success", new ReadGoalDto(
                updatedGoal.getId(),
                updatedGoal.getStatus(),
                updatedGoal.getStartsAt(),
                updatedGoal.getEndsAt())), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try{
            Goal deleteddGoal = goalService.delete(id);

            return new ResponseEntity<>(new Response<>(true,"success", new ReadGoalDto(
                    deleteddGoal.getId(),
                    deleteddGoal.getStatus(),
                    deleteddGoal.getStartsAt(),
                    deleteddGoal.getEndsAt())), HttpStatus.CREATED);

        }catch (Exception ex)  {
            return new ResponseEntity<>(
                    new Response<>(false,"Failed", "Please check no goalWorkout attached to the goal"), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}/workouts")
    public ResponseEntity<?> getGoalWorkouts(@PathVariable int id){
        return new ResponseEntity<>(
                new Response<>(true,"success",goalService.getGoalWorkouts(id)), HttpStatus.OK);
    }
    @PostMapping("/{id}/workouts/{workoutId}")
    public ResponseEntity<?> addWorkout(@PathVariable int id,@PathVariable int workoutId){

        GoalWorkout goalWorkout = goalService.addWorkout(id,workoutId);

        return new ResponseEntity<>(new Response<>(true,"success", goalWorkout), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/workouts/{goalWorkoutId}")
    public ResponseEntity<?> updateGoalWorkout(@PathVariable int id,@PathVariable int goalWorkoutId,@RequestBody UpdateGoalWorkoutDto updateGoalWorkoutDto){

    return new ResponseEntity<>(
                new Response<>(true,"success", goalService.updateGoalWorkout(id,goalWorkoutId,updateGoalWorkoutDto)), HttpStatus.CREATED);

    }
    @DeleteMapping("/{goalId}/workouts/{goalWorkoutId}")
    public ResponseEntity<?> removeGoalWorkout(@PathVariable int goalId,@RequestBody Integer [] goalWorkoutId){

        List<GoalWorkout> goalWorkouts = goalService.removeGoalWorkout(goalId,goalWorkoutId);

        return new ResponseEntity<>(new Response<>(true,"success", goalWorkouts), HttpStatus.CREATED);
    }

}
