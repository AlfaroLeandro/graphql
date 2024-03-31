package com.vinsguru.graphqlplayground.sec01.lec01;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class GraphqlController {

    @QueryMapping("sayHello")
    public Mono<String> helloWorld(){
        return Mono.just("Hello world");
    }

    @QueryMapping("sayHelloTo")
    public Mono<String> sayHelloTo(@Argument String name) {
        return Mono.fromSupplier(() -> "Hello " + name);
    }


    @QueryMapping("random")
    public Mono<Integer> random(@Argument String name) {
        return Mono.fromSupplier(() -> ThreadLocalRandom.current().nextInt(1,100));
    }

}
