package com.vinsguru.graphqlplayground.lec06.dto;


import java.util.List;

public record CustomerWithOrder(
        Integer id,
        String name,
        Integer age,
        String city,
        List<CustomerOrderDTO> orders
) {
}
