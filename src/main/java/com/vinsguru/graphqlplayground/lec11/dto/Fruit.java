package com.vinsguru.graphqlplayground.lec11.dto;

import java.time.LocalDate;
import java.util.UUID;

public record Fruit(
        String description,
        LocalDate expiryDate

) {
}
