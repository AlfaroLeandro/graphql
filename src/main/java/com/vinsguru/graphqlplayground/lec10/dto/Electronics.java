package com.vinsguru.graphqlplayground.lec10.dto;

import java.time.LocalDate;
import java.util.UUID;

public record Electronics(
        UUID id,
        String description,
        Integer price,
        String brand

) {
}
