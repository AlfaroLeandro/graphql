package com.vinsguru.graphqlplayground.sec01.lec05.dto;

public record Customer (
        Integer id,
        String name,
        Integer age,
        String city
) {
}
