package com.vinsguru.graphqlplayground.lec07.dto;

public record Customer (
        Integer id,
        String name,
        Integer age,
        String city
) {
}
