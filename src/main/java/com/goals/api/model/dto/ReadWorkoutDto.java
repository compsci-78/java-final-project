package com.goals.api.model.dto;

import java.util.List;

public record ReadWorkoutDto(
        int id,
        String name,
        String type,
        List<ReadWorkoutExerciseDto> workoutExercises) {
}
