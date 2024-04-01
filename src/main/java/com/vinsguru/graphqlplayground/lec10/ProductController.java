package com.vinsguru.graphqlplayground.lec10;

import com.vinsguru.graphqlplayground.lec10.dto.Book;
import com.vinsguru.graphqlplayground.lec10.dto.Electronics;
import com.vinsguru.graphqlplayground.lec10.dto.FruitDTO;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.UUID;

@Controller
public class ProductController {

    @QueryMapping
    public Flux<Object> products() {
        return Flux.just(
                new FruitDTO(UUID.randomUUID(),"banana", 1, LocalDate.now().plusDays(3)),
                new FruitDTO(UUID.randomUUID(),"apple", 2, LocalDate.now().plusDays(1)),
                new Electronics(UUID.randomUUID(),"mac book", 600, "APPLE"),
                new Electronics(UUID.randomUUID(),"phone", 100, "SAMSUNG"),
                new Book(UUID.randomUUID(),"java", 40, "asd")
        );
    }

}
