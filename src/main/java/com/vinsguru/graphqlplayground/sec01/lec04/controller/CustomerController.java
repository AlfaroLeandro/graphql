package com.vinsguru.graphqlplayground.sec01.lec04.controller;

import com.vinsguru.graphqlplayground.sec01.lec04.dto.Customer;
import com.vinsguru.graphqlplayground.sec01.lec04.dto.CustomerOrderDTO;
import com.vinsguru.graphqlplayground.sec01.lec04.service.CustomerService;
import com.vinsguru.graphqlplayground.sec01.lec04.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private OrderService orderService;

//    @QueryMapping("customersAll")
    @SchemaMapping(typeName = "Query")
    public Flux<Customer> customers() {
        return this.service.allCustomers();
//                .map(c -> orderService.ordersByCustomerName(c.name()));
    }

    //N + 1
    @BatchMapping(typeName = "Customer") //VINCULADO POR NOMBRE DE METODO (orders)
    public Flux<List<CustomerOrderDTO>> orders(List<Customer> list) {
        return this.orderService.ordersByCustomerName(
                list.stream()
                    .map(Customer::name)
                    .collect(Collectors.toList()));
    }

}
