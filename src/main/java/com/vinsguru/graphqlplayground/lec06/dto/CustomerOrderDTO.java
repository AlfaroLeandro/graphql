package com.vinsguru.graphqlplayground.lec06.dto;

import java.util.UUID;

public record CustomerOrderDTO(
        UUID id,
        String description

) {
}
