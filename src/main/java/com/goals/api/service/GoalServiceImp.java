package com.goals.api.service;

import com.goals.api.model.*;
import com.goals.api.model.dto.CreateGoalDto;
import com.goals.api.model.dto.UpdateGoalDto;
import com.goals.api.model.dto.UpdateGoalWorkoutDto;
import com.goals.api.repository.GoalRepository;
import com.goals.api.repository.GoalWorkoutRepository;
import com.goals.api.repository.UserRepository;
import com.goals.api.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
@Service
public class GoalServiceImp implements GoalService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private GoalWorkoutRepository goalWorkoutRepository;
    @Autowired
    private WorkoutRepository workoutRepository;
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
    public Goal create(CreateGoalDto entity) {
        // checking the user
        User foundUser = userRepository.findById(entity.userId())
                .orElseThrow(()-> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,"No user matches the provided id"+entity.userId()));

        // make a list of workouts and throw an error not found
        List<Workout> workouts =  entity.workouts().stream()
                .map(id ->  workoutRepository.findById(id)
                        .orElseThrow(()-> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,"No workout matches the provided id"+id)))
                .toList();

        // create a goal
        Goal goal = new Goal();
        goal.setUser(foundUser);
        goal.setStatus(Status.PENDING);
        goal.setStartsAt(entity.startsAt());
        goal.setEndsAt(entity.endsAt());
        Goal createdGoal = goalRepository.save(goal);

        // make a list of goalWorkouts and save at once
        List<GoalWorkout> goalWorkouts =  workouts.stream().map(wk -> {
                    GoalWorkout gw = new GoalWorkout();
                    gw.setStatus(Status.PENDING);
                    gw.setWorkout(wk);
                    gw.setGoal(createdGoal);
                    return gw;
                } ).toList();

        goalWorkoutRepository.saveAll(goalWorkouts);

        return createdGoal;
    }
    @Override
    public Goal update(Integer id, Goal entity) {
        return null;
    }
    public Goal update(Integer id, UpdateGoalDto entity)    {
        // find the goal
        Goal foundGoal = goalRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No goal matches the provided id"));

        foundGoal.setStartsAt(entity.startsAt());
        foundGoal.setEndsAt(entity.endsAt());

        return goalRepository.save(foundGoal);
    }
    @Override
    public Goal delete(Integer id) {
        Goal foundGoal = goalRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No goal matches the provided id"));
        goalRepository.delete(foundGoal);
        return foundGoal;
    }
    @Override
    public GoalWorkout addWorkout(Integer goalId, Integer workoutId){
        Goal foundGoal = goalRepository.findById(goalId)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No goal matches the provided id"));

        Workout foundWorkout =workoutRepository.findById(workoutId)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No workout matches the provided id"));

        GoalWorkout goalWorkout = new GoalWorkout();
        goalWorkout.setStatus(Status.PENDING);
        goalWorkout.setGoal(foundGoal);
        goalWorkout.setWorkout(foundWorkout);

        return goalWorkoutRepository.save(goalWorkout);
    }
    @Override
    public List<GoalWorkout> removeGoalWorkout(Integer goalId, Integer[] goalWorkoutIds) {
        Goal foundGoal = goalRepository.findById(goalId)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No goal matches the provided id"));

        List<GoalWorkout> goalWorkouts = Arrays.stream(goalWorkoutIds).map(id->{
            GoalWorkout goalWorkout = goalWorkoutRepository.findById(id)
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,"No goal matches the provided id"));

            if (goalWorkout.getGoal().getId()!=goalId){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"No goal matches the provided goalWorkout id");
            }
            return goalWorkout;
        }).toList();

        goalWorkoutRepository.deleteAll(goalWorkouts);
        return goalWorkouts;
    }
    @Override
    public List<GoalWorkout> getGoalWorkouts(Integer id){
        goalRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No goal matches the provided id"));
        return goalWorkoutRepository.findByGoalId(id);
    }
    @Override
    public GoalWorkout updateGoalWorkout(Integer goalId,Integer goalWorkoutId, UpdateGoalWorkoutDto entity){

        Status status = Status.valueOf(entity.status());

        //if (!entity.status().equals(Status.PENDING)&& !entity.status().equals(Status.COMPLETED))
        if (!status.equals(Status.PENDING)&& !status.equals(Status.COMPLETED))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid status");
        }

        Goal foundGoal = goalRepository.findById(goalWorkoutId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No goal matches the provided id"));

        GoalWorkout foundGoalWorkout =  goalWorkoutRepository.findById(goalWorkoutId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No goalWorkout matches the provided id"));

        if (foundGoal.getId()!= foundGoalWorkout.getGoal().getId())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No goal and goalWorkout matches the provided id's");
        }

        //foundGoalWorkout.setStatus(entity.status());
        foundGoalWorkout.setStatus(status);

        return goalWorkoutRepository.save(foundGoalWorkout);
    }
}
