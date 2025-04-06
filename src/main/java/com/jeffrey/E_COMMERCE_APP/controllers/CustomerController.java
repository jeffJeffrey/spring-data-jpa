package com.jeffrey.E_COMMERCE_APP.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jeffrey.E_COMMERCE_APP.dtos.CustomerRequest;
import com.jeffrey.E_COMMERCE_APP.models.Customer;
import com.jeffrey.E_COMMERCE_APP.services.CustomerService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CustomerController {
    

    private  final CustomerService customerService;

    @QueryMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }

    @QueryMapping
    public Customer getCustomerById(@Argument Long id){
        return customerService.getById(id);
    }

    @MutationMapping
    public Customer updateCustomer(@Argument Long id, @Argument CustomerRequest customerRequest){
        return customerService.update(id, customerRequest);
    }

    @MutationMapping
    public Customer createCustomer(@Argument CustomerRequest customerRequest){
        return customerService.create(customerRequest);
    }

    @MutationMapping
    Boolean  deleteCustomer (@Argument Long id){
        customerService.delete(id);
        return true;
    }
}