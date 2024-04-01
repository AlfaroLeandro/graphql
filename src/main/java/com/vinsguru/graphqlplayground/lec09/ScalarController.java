package com.vinsguru.graphqlplayground.lec09;

import com.vinsguru.graphqlplayground.lec09.dto.AllTypes;
import com.vinsguru.graphqlplayground.lec09.dto.Car;
import com.vinsguru.graphqlplayground.lec09.dto.Product;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Controller
public class ScalarController {

    private AllTypes allTypes =
            new AllTypes(
                    UUID.randomUUID(),
                    10,
                    1.21f,
                    "atlanta",
                    false,
                    120000000L,
                    Byte.valueOf("12"),
                    Short.valueOf("100"),
                    BigDecimal.valueOf(123456789.123456789),
                    BigInteger.valueOf(1234567890),
                    LocalDate.now(),
                    LocalTime.now(),
                    OffsetDateTime.now(),
                    Car.BMW
            );

    @QueryMapping
    public Mono<AllTypes> get() {
        return Mono.just(allTypes);
    }

    @QueryMapping
    public Flux<Product> products() {
        return Flux.just(
                new Product("banana", Map.of(
                   "expiry date", "01/01/2025",
                   "color", "yellow"
                )),
                new Product("mac", Map.of(
                        "cpu", "8",
                        "ram", "32g"
                ))
        );
    }

}
