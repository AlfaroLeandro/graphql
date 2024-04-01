package com.vinsguru.graphqlplayground.lec06.service;

import com.vinsguru.graphqlplayground.lec06.dto.Customer;
import com.vinsguru.graphqlplayground.lec06.dto.CustomerOrderDTO;
import com.vinsguru.graphqlplayground.lec06.dto.CustomerWithOrder;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

@Service
public class CustomerOrderDataFetcher {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    public Flux<CustomerWithOrder> customerOrders(DataFetchingFieldSelectionSet selectionSet) {
        var includeOrders = selectionSet.contains("orders");
        return this.customerService.allCustomers()
                .map(c -> this.toCustomerWithOrder(c, Collections.emptyList()))
                .transform(this.updateOrdersTransformer(includeOrders));
    }

    private UnaryOperator<Flux<CustomerWithOrder>> updateOrdersTransformer(boolean includeOrders) {
        return includeOrders? f -> f.flatMapSequential(this::fetchOrders) : f -> f;
    }

    private Mono<CustomerWithOrder> fetchOrders(CustomerWithOrder c) {
        return this.orderService.ordersByCustomerName(c.name())
                .collectList()
                .map(l -> this.toCustomerWithOrder(new Customer(c.id(), c.name(), c.age(), c.city()), l));
    }

//    private Mono<CustomerWithOrder> fetchOrders(Customer c) {
//        return this.orderService.ordersByCustomerName(c.name())
//                .collectList()
//                .map(l -> this.toCustomerWithOrder(c, l));
//    }

    private CustomerWithOrder toCustomerWithOrder(Customer c, List<CustomerOrderDTO> l) {
        return new CustomerWithOrder(
                c.id(),
                c.name(),
                c.age(),
                c.city(),
                l
        );
    }


}
