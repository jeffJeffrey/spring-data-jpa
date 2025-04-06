package com.jeffrey.E_COMMERCE_APP.services;

import java.util.List;

import com.jeffrey.E_COMMERCE_APP.dtos.CustomerRequest;
import com.jeffrey.E_COMMERCE_APP.models.Customer;

public interface CustomerService {

    List <Customer> getAll ();
    Customer getById(Long id);
    Customer create(CustomerRequest customerRequest);
    Customer update(Long id, CustomerRequest CustomerRequest);
    void delete (Long id);
}
