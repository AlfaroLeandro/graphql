package com.vinsguru.graphqlplayground.lec04.service;

import com.vinsguru.graphqlplayground.lec04.dto.Customer;
import com.vinsguru.graphqlplayground.lec04.dto.CustomerOrderDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    private final Map<String, List<CustomerOrderDTO>> map = Map.of(
            "leandro", List.of(
                    new CustomerOrderDTO(UUID.randomUUID(), "leandro-asd-1"),
                    new CustomerOrderDTO(UUID.randomUUID(), "leandro-asd-2")
            ),
            "laura", List.of(
                    new CustomerOrderDTO(UUID.randomUUID(), "laura-dfg-1"),
                    new CustomerOrderDTO(UUID.randomUUID(), "laura-dfg-2"),
                    new CustomerOrderDTO(UUID.randomUUID(), "laura-dfg-3")
            )
    );

    public Flux<CustomerOrderDTO> ordersByCustomerName(String name) {
        return Flux.fromIterable(map.getOrDefault(name, Collections.emptyList()));
    }

    public Flux<List<CustomerOrderDTO>> ordersByCustomerName(List<String> names) {
//        return Flux.fromIterable(names)
//                .map(n -> map.getOrDefault(n, Collections.emptyList()));

//        return Flux.fromIterable(names) --> ERROR, DEVUELVE SOLO 2 ITEMS Y ESPERA 4 (TOTAL DE CUSTOMERS)
//                .flatMap(this::fetchOrders);

//        return Flux.fromIterable(names) --> ERROR, DEVUELVE LAS ORDENES MEZCLADAS (NO CORRESPONDEN A SU CUSTOMER)
//                .flatMap(n -> fetchOrders(n).defaultIfEmpty(Collections.emptyList()));

        return Flux.fromIterable(names)
                .flatMapSequential(n -> fetchOrders(n).defaultIfEmpty(Collections.emptyList()));
    }

    //algun recurso externo
    private Mono<List<CustomerOrderDTO>> fetchOrders(String name) {
        return Mono.justOrEmpty(map.get(name));
    }

    public Mono<Map<Customer, List<CustomerOrderDTO>>> fetchCustomersAsMap(List<Customer> customers) {
        return Flux.fromIterable(customers)
                .map(c -> Tuples.of(c, map.getOrDefault(c.name(), Collections.emptyList())))
                .collectMap(
                        Tuple2::getT1,
                        Tuple2::getT2
                );
    }

}
