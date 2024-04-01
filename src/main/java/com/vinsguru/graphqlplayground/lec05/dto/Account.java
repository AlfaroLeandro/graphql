package com.vinsguru.graphqlplayground.lec05.dto;

import java.util.UUID;

public record Account(

        UUID id,
        Integer amount,
        String accountType
) {
}
