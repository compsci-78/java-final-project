package com.goals.api.model.dto;

public record ReadWorkoutExerciseDto(
        int id,
        int sets,
        int reps,
        int restMins,
        int duration,
        ReadExerciseDto exercise ) {
}
