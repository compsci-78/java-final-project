package com.goals.api.model.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public record UpdateGoalDto(
        @NotNull(message = "should not be null")
        Date startsAt,
        @NotNull(message = "should not be null")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "yyyy-MM-ddd")
        Date endsAt) {
}
