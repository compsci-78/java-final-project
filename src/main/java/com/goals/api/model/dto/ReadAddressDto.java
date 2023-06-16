package com.goals.api.model.dto;

public record ReadAddressDto(
        int id,
        String line1,
        String line2,
        String postalCode,
        String city,
        String country
) {
}
