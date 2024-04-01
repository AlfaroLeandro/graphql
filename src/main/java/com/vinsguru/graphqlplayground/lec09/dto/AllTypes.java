package com.vinsguru.graphqlplayground.lec09.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.UUID;

public record AllTypes(
        UUID id,
        Integer height,
        Float temperature,
        String city,
        Boolean isValid,
        Long distance,
        Byte ageInYears,
        Short ageInMonth,
        BigDecimal bigDecimal,
        BigInteger bigInteger,
        LocalDate date,
        LocalTime time,
        OffsetDateTime dateTime,
        Car car
) {
}
