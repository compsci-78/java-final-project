package com.goals.api.service;

import com.goals.api.model.Goal;
import com.goals.api.model.GoalWorkout;
import com.goals.api.model.dto.CreateGoalDto;
import com.goals.api.model.dto.UpdateGoalDto;
import com.goals.api.model.dto.UpdateGoalWorkoutDto;


import java.util.List;

public interface GoalService extends BasicService<Goal,Integer> {
    Goal update(Integer id, UpdateGoalDto updateGoalDto);
    Goal create(CreateGoalDto createGoalDto);
    List<GoalWorkout> addWorkouts(Integer goalId, Integer [] workoutId);
    GoalWorkout updateGoalWorkout(Integer goalId,Integer goalWorkoutId, UpdateGoalWorkoutDto entity);
    List<GoalWorkout> removeGoalWorkouts(Integer goalId, Integer [] workouts);
    List<GoalWorkout> getGoalWorkouts(Integer goalId );

}
