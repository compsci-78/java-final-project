package com.goals.api.model.dto;

public record ReadUserDto(
        int id,
        String firstName,
        String lastName,
        String email,
        ReadAddressDto address
) {
}
