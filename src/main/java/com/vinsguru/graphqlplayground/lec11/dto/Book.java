package com.vinsguru.graphqlplayground.lec11.dto;

import java.util.UUID;

public record Book(
        UUID id,
        String description,
        Integer price,
        String author

) {
}
