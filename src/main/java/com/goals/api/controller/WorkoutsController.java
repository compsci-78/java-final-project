package com.goals.api.controller;

import com.goals.api.model.Workout;
import com.goals.api.model.dto.*;
import com.goals.api.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("workouts")
public class WorkoutsController {
    @Autowired
    private WorkoutService workoutService;
    @GetMapping()
    public ResponseEntity<?> getAll(){

        List<ReadWorkoutDto> readWorkoutDtos = workoutService.getAll().stream()
                .map(workout -> {
                    List<ReadWorkoutExerciseDto> workoutExerciseDtos = workout.getWorkoutExercises().stream().map(we->{
                        ReadExerciseDto readExerciseDto = new ReadExerciseDto(
                                we.getExercise().getId(),
                                we.getExercise().getName(),
                                we.getExercise().getDescription(),
                                we.getExercise().getMuscleGroup(),
                                we.getExercise().getImageLink(),
                                we.getExercise().getVideoLink());

                        return new ReadWorkoutExerciseDto(
                                we.getId(),
                                we.getSets(),
                                we.getReps(),
                                we.getRestMins(),
                                we.getDuration(),
                                readExerciseDto);}).toList();

                    return new ReadWorkoutDto(workout.getId(),workout.getName(),workout.getType(),workoutExerciseDtos);
                }).toList();

        return new ResponseEntity<>( new Response<>(true,"success",readWorkoutDtos), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        Workout workout = workoutService.get(id);
        List<ReadWorkoutExerciseDto> workoutExerciseDtos = workout.getWorkoutExercises().stream().map(we->{
            ReadExerciseDto readExerciseDto = new ReadExerciseDto(
                    we.getExercise().getId(),
                    we.getExercise().getName(),
                    we.getExercise().getDescription(),
                    we.getExercise().getMuscleGroup(),
                    we.getExercise().getImageLink(),
                    we.getExercise().getVideoLink());

            return new ReadWorkoutExerciseDto(
                    we.getId(),
                    we.getSets(),
                    we.getReps(),
                    we.getRestMins(),
                    we.getDuration(),
                    readExerciseDto);}).toList();

        ReadWorkoutDto readWorkoutDto = new ReadWorkoutDto(workout.getId(),workout.getName(),workout.getType(),workoutExerciseDtos);

        return new ResponseEntity<>( new Response<>(true,"success",readWorkoutDto), HttpStatus.OK);
    }
}
