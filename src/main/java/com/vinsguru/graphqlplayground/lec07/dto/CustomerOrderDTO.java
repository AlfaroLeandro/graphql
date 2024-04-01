package com.vinsguru.graphqlplayground.lec07.dto;

import java.util.UUID;

public record CustomerOrderDTO(
        UUID id,
        String description

) {
}
