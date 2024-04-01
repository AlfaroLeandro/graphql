package com.vinsguru.graphqlplayground.lec06.controller;

import com.vinsguru.graphqlplayground.lec06.dto.CustomerWithOrder;
import com.vinsguru.graphqlplayground.lec06.service.CustomerOrderDataFetcher;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class CustomerController {

//    @Autowired
//    private CustomerService service;
//
//    @Autowired
//    private OrderService orderService;

    @Autowired
    private CustomerOrderDataFetcher service;



//    @QueryMapping("customersAll")
    @SchemaMapping(typeName = "Query")
    public Flux<CustomerWithOrder> customers(DataFetchingFieldSelectionSet selectionSet) {
        return this.service.customerOrders(selectionSet);
//                .map(c -> orderService.ordersByCustomerName(c.name()));
    }

//    @SchemaMapping(typeName = "Customer") //VINCULADO POR NOMBRE DE METODO (orders)
//    public Flux<CustomerOrderDTO> orders(Customer customer) {
//        return this.orderService.ordersByCustomerName(customer.name());
//    }

}
