package com.vinsguru.graphqlplayground.lec03.dto;

public record Customer (
        Integer id,
        String name,
        Integer age,
        String city
) {
}
