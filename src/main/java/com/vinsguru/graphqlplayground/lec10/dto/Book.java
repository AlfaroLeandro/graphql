package com.vinsguru.graphqlplayground.lec10.dto;

import java.time.LocalDate;
import java.util.UUID;

public record Book(
        UUID id,
        String description,
        Integer price,
        String author

) {
}
