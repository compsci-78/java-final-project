package com.goals.api.model.dto;

import com.goals.api.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateGoalWorkoutDto(
        @NotNull(message = "should not be null")
        @NotBlank(message = "should not be empty")
        Status status) {
}
