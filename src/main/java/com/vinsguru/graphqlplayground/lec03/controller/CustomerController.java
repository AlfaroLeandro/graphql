package com.vinsguru.graphqlplayground.lec03.controller;

import com.vinsguru.graphqlplayground.lec03.dto.Customer;
import com.vinsguru.graphqlplayground.lec03.dto.CustomerOrderDTO;
import com.vinsguru.graphqlplayground.lec03.service.CustomerService;
import com.vinsguru.graphqlplayground.lec03.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

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

    @SchemaMapping(typeName = "Customer") //VINCULADO POR NOMBRE DE METODO (orders)
    public Flux<CustomerOrderDTO> orders(Customer customer, @Argument Integer limit) {
        return this.orderService.ordersByCustomerName(customer.name())
                .take(limit);
    }

}
