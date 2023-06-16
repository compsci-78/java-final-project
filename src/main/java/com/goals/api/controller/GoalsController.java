package com.goals.api.controller;

import com.goals.api.model.Goal;
import com.goals.api.model.GoalWorkout;
import com.goals.api.model.dto.*;
import com.goals.api.service.GoalService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("goals")
public class GoalsController {
    @Autowired
    private GoalService goalService;

    @GetMapping()
    public ResponseEntity<?> getAll(){

        List<Goal> goals = goalService.getAll();
        List<ReadGoalDto> readGoalDtos = new ArrayList<>();
        goals.forEach(goal->{
            List<ReadGoalWorkoutDto> readGoalWorkoutDtos = goal.getGoalWorkouts().stream()
                    .map(g->{
                        return new ReadGoalWorkoutDto(
                                g.getId(),
                                g.getWorkout().getId(),
                                g.getWorkout().getName(),
                                g.getWorkout().getType(),
                                g.getStatus().toString());
                    }).toList();
            ReadGoalDto readGoalDto =new ReadGoalDto(
                    goal.getId(),
                    goal.getStatus(),
                    goal.getStartsAt(),
                    goal.getEndsAt(),
                    readGoalWorkoutDtos);

            readGoalDtos.add(readGoalDto);
        });

        return new ResponseEntity<>(
                new Response<>(true,"success",readGoalDtos), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        Goal goal = goalService.get(id);

        List<ReadGoalWorkoutDto> readGoalWorkoutDtos = goal.getGoalWorkouts().stream()
                .map(g->{
                    return new ReadGoalWorkoutDto(
                            g.getId(),
                            g.getWorkout().getId(),
                            g.getWorkout().getName(),
                            g.getWorkout().getType(),
                            g.getStatus().toString());
                }).toList();


        return new ResponseEntity<>(
                new Response<>(true,"success", new ReadGoalDto(
                        goal.getId(),
                        goal.getStatus(),
                        goal.getStartsAt(),
                        goal.getEndsAt(),
                        readGoalWorkoutDtos))
                , HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid CreateGoalDto createGoalDto){

        Goal createdGoal = goalService.create(createGoalDto);

        List<ReadGoalWorkoutDto> readGoalWorkoutDtos = createdGoal.getGoalWorkouts().stream()
                .map(g->{
                    return new ReadGoalWorkoutDto(
                            g.getId(),
                            g.getWorkout().getId(),
                            g.getWorkout().getName(),
                            g.getWorkout().getType(),
                            g.getStatus().toString());
                }).toList();

        return new ResponseEntity<>(new Response<>(true,"success", new ReadGoalDto(
                createdGoal.getId(),
                createdGoal.getStatus(),
                createdGoal.getStartsAt(),
                createdGoal.getEndsAt(),
                readGoalWorkoutDtos))
                , HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody @Valid UpdateGoalDto updateGoalDto){

        Goal updatedGoal = goalService.update(id,updateGoalDto);

        List<ReadGoalWorkoutDto> readGoalWorkoutDtos = updatedGoal.getGoalWorkouts().stream()
                .map(g->{
                    return new ReadGoalWorkoutDto(
                            g.getId(),
                            g.getWorkout().getId(),
                            g.getWorkout().getName(),
                            g.getWorkout().getType(),
                            g.getStatus().toString());
                }).toList();

        return new ResponseEntity<>(new Response<>(true,"success", new ReadGoalDto(
                updatedGoal.getId(),
                updatedGoal.getStatus(),
                updatedGoal.getStartsAt(),
                updatedGoal.getEndsAt(),
                readGoalWorkoutDtos))
                , HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){

            Goal deletedGoal = goalService.delete(id);

//            List<ReadGoalWorkoutDto> readGoalWorkoutDtos = deletedGoal.getGoalWorkouts().stream()
//                    .map(g-> new ReadGoalWorkoutDto(
//                            g.getId(),
//                            g.getWorkout().getId(),
//                            g.getWorkout().getName(),
//                            g.getWorkout().getType(),
//                            g.getStatus().toString())).toList();

            return new ResponseEntity<>(new Response<>(true,"success", new ReadGoalDto(
                    deletedGoal.getId(),
                    deletedGoal.getStatus(),
                    deletedGoal.getStartsAt(),
                    deletedGoal.getEndsAt(),
                    null))
                    ,HttpStatus.CREATED);
    }
    @GetMapping("/{id}/workouts")
    public ResponseEntity<?> getGoalWorkouts(@PathVariable int id){
        return new ResponseEntity<>(
                new Response<>(true,"success",goalService.getGoalWorkouts(id)), HttpStatus.OK);
    }
    @PostMapping("/{id}/workouts")
    public ResponseEntity<?> addWorkout(@PathVariable int id,@RequestBody WorkoutRequest workoutRequest){

        List<GoalWorkout> goalWorkout = goalService.addWorkouts(id,workoutRequest.workoutIds());

        List<ReadGoalWorkoutDto> readGoalWorkoutDtos = goalWorkout.stream().map(gw->{

            return  new ReadGoalWorkoutDto(
                    gw.getId(),
                    gw.getWorkout().getId(),
                    gw.getWorkout().getName(),
                    gw.getWorkout().getType(),
                    gw.getStatus().toString());
        }).toList();

        return new ResponseEntity<>(new Response<>(true,"success", readGoalWorkoutDtos), HttpStatus.CREATED);
    }
    @PutMapping("/{id}/workouts/{goalWorkoutId}")
    public ResponseEntity<?> updateGoalWorkout(@PathVariable int id,@PathVariable int goalWorkoutId,@RequestBody UpdateGoalWorkoutDto updateGoalWorkoutDto){

    return new ResponseEntity<>(
                new Response<>(true,"success", goalService.updateGoalWorkout(id,goalWorkoutId,updateGoalWorkoutDto)), HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}/workouts")
    public ResponseEntity<?> removeGoalWorkout(@PathVariable int id,@RequestBody GoalWorkoutRequest goalWorkoutRequest){

        List<GoalWorkout> goalWorkouts = goalService.removeGoalWorkouts(id,goalWorkoutRequest.goalWorkoutIds());

        return new ResponseEntity<>(new Response<>(true,"success", goalWorkouts), HttpStatus.CREATED);
    }

}
