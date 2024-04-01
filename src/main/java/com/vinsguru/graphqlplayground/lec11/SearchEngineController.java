package com.vinsguru.graphqlplayground.lec11;

import com.vinsguru.graphqlplayground.lec11.dto.Book;
import com.vinsguru.graphqlplayground.lec11.dto.Electronics;
import com.vinsguru.graphqlplayground.lec11.dto.Fruit;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

@Controller
public class SearchEngineController {

    List<Object> list = List.of(new Fruit("banana", LocalDate.now().plusDays(3)),
            new Fruit("apple", LocalDate.now().plusDays(1)),
            new Electronics(UUID.randomUUID(),"mac book", 600, "APPLE"),
            new Electronics(UUID.randomUUID(),"phone", 100, "SAMSUNG"),
            new Book("java",  "venkat"));

    @QueryMapping
    public Flux<Object> search() {
        return Mono.fromSupplier(() -> new ArrayList(list))
                .doOnNext(Collections::shuffle)
                .flatMapMany(Flux::fromIterable)
//                .flatMapIterable(Function.identity()) //CONVIERTE UN MONO DE LISTA EN UN FLUX
                .take(ThreadLocalRandom.current().nextInt(0, list.size()));
    }

}
