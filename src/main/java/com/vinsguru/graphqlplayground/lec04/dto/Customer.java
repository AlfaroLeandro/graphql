package com.vinsguru.graphqlplayground.lec04.dto;

public record Customer (
        Integer id,
        String name,
        Integer age,
        String city
) {
}
