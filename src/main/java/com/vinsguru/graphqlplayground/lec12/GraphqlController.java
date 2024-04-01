package com.vinsguru.graphqlplayground.lec12;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class GraphqlController {

    @QueryMapping("sayHelloTo")
    public Mono<String> sayHello(@Argument String name) {
        return Mono.fromSupplier(() -> "Hello " + name);
    }



}
