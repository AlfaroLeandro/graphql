package com.vinsguru.graphqlplayground.sec01.lec05.controller;

import com.vinsguru.graphqlplayground.sec01.lec05.dto.Address;
import com.vinsguru.graphqlplayground.sec01.lec05.dto.Customer;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AddressController {

    @SchemaMapping
    public Mono<Address> address(Customer customer) {
        return Mono.just(
                new Address(customer.name() + " street",
                             customer.name() + " city"));
    }
}
