package com.vinsguru.graphqlplayground.lec02.dto;

public record Customer (
        Integer id,
        String name,
        Integer age,
        String city
) {
}
