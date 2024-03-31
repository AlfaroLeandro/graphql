package com.vinsguru.graphqlplayground.sec01.lec03.dto;

import java.util.UUID;

public record CustomerOrderDTO(
        UUID id,
        String description

) {
}
