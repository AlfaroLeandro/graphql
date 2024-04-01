package com.vinsguru.graphqlplayground.lec06.controller;

import com.vinsguru.graphqlplayground.lec06.dto.Customer;
import com.vinsguru.graphqlplayground.lec06.dto.CustomerOrderDTO;
import com.vinsguru.graphqlplayground.lec06.dto.CustomerWithOrder;
import com.vinsguru.graphqlplayground.lec06.service.CustomerService;
import com.vinsguru.graphqlplayground.lec06.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerService service;

    @Autowired
    private OrderService orderService;

    @GetMapping("customer")
    public Flux<CustomerWithOrder> customerOrders() {
        return this.service.allCustomers()
                .flatMap(c ->
                        this.orderService.ordersByCustomerName(c.name())
                        .collectList()
                        .map(l -> this.toCustomerWithOrder(c,l))
                );
    }

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
