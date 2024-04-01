package com.vinsguru.graphqlplayground.lec06.dto;

public record Customer (
        Integer id,
        String name,
        Integer age,
        String city
) {
}
