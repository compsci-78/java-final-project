package com.goals.api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.goals.api.model.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record ReadGoalDto(
        int id,
        Status status,
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date startsAt,
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date endsAt) {
}
