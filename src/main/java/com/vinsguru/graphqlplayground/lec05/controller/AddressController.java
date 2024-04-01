package com.vinsguru.graphqlplayground.lec05.controller;

import com.vinsguru.graphqlplayground.lec05.dto.Address;
import com.vinsguru.graphqlplayground.lec05.dto.Customer;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AddressController {

    @SchemaMapping
    public Mono<Address> address(Customer customer, DataFetchingFieldSelectionSet selectionSet) {
        System.out.println(
                "address: " + selectionSet.getFields()
        );

        return Mono.just(
                new Address(customer.name() + " street",
                             customer.name() + " city"));
    }
}
