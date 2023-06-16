package com.goals.api.model.dto;

public record ReadGoalWorkoutDto(
        int id,
        int workoutId,
        String name,
        String type,
        String status
) {
}
