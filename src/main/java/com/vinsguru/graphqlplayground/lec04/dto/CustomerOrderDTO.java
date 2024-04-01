package com.vinsguru.graphqlplayground.lec04.dto;

import java.util.UUID;

public record CustomerOrderDTO(
        UUID id,
        String description

) {
}
