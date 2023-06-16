package com.goals.api.model.dto;

public record ReadExerciseDto(
        int id,
        String name,
        String description,
        String muscleGroup,
        String imageLink,
        String videoLink) {
}
