package com.goals.api.repository;

import com.goals.api.model.GoalWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalWorkoutRepository extends JpaRepository<GoalWorkout,Integer> {
    //@Query("SELECT gw FROM GoalWorkout gw WHERE gw.goal.id = ?1")
    List<GoalWorkout> findByGoalId(Integer goalId);
}
