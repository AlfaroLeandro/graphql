package com.vinsguru.graphqlplayground.lec04.service;

import com.vinsguru.graphqlplayground.lec04.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            new Customer(1, "sam", 20, "atlanta"),
            new Customer(23, "leandro", 22, "lafe"),
            new Customer(133, "asd", 44, "aasdsaf"),
            new Customer(43, "asd4654", 88, "54654asd3as2")
    );

    public Flux<Customer> allCustomers() {
        return flux;
    }

    public Mono<Customer> filter(Integer id) {
        return flux.filter(c -> c.id().equals(id))
                .next();
    }

    public Flux<Customer> nameContains(String name) {
        return flux.filter(c -> c.name().contains(name));
    }

}
