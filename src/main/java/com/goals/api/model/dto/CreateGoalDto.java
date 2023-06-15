package com.goals.api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public record CreateGoalDto(
        @NotNull(message = "should not be null")
        Integer userId,
        @NotNull(message = "should not be null")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "yyyy-MM-dd")
        @NotNull(message = "should not be null")
        Date startsAt,
        @NotNull(message = "should not be null")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date endsAt,
        @NotNull(message = "should not be null")
        List<Integer> workouts) {
}
