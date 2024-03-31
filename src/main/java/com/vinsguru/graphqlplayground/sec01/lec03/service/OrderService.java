package com.vinsguru.graphqlplayground.sec01.lec03.service;

import com.vinsguru.graphqlplayground.sec01.lec03.dto.CustomerOrderDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

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

}
