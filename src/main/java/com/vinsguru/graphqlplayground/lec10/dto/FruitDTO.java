package com.vinsguru.graphqlplayground.lec10.dto;

import java.time.LocalDate;
import java.util.UUID;

public record FruitDTO(
        UUID id,
        String description,
        Integer price,
        LocalDate expiryDate

) {
}
