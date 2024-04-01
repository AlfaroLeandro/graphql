package com.vinsguru.graphqlplayground.lec03.dto;

import java.util.UUID;

public record CustomerOrderDTO(
        UUID id,
        String description

) {
}
