package com.vinsguru.graphqlplayground.lec09.dto;

import java.util.Map;

public record Product(

        String name,
        Map<String, String> attributes

) {
}
