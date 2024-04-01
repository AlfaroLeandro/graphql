package com.vinsguru.graphqlplayground.lec11.dto;

import java.time.LocalDate;
import java.util.UUID;

public record Fruit(
        UUID id,
        String description,
        Integer price,
        LocalDate expiryDate

) {
}
