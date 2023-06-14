package com.goals.api.repository;

import com.goals.api.model.GoalWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalWorkoutRepository extends JpaRepository<GoalWorkout,Integer> {
}
