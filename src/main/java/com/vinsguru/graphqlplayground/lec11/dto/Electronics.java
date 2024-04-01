package com.vinsguru.graphqlplayground.lec11.dto;

import java.util.UUID;

public record Electronics(
        UUID id,
        String description,
        Integer price,
        String brand

) {
}
