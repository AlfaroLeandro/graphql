package com.vinsguru.graphqlplayground.sec01.lec05.dto;

import java.util.UUID;

public record Account(

        UUID id,
        Integer amount,
        String accountType
) {
}
