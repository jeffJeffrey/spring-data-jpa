package com.jeffrey.E_COMMERCE_APP.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeffrey.E_COMMERCE_APP.dtos.CustomerRequest;
import com.jeffrey.E_COMMERCE_APP.models.Customer;
import com.jeffrey.E_COMMERCE_APP.repository.CustomerRepository;
import com.jeffrey.E_COMMERCE_APP.services.CustomerService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        List <Customer>  customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Customer getById(Long id) {
        Customer  customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        return customer;
    }

    @Override
    public Customer create(CustomerRequest cRequest) {
        Customer customer = new Customer(cRequest.name(), cRequest.email());
        Customer customerSAved = customerRepository.save(customer);
        return customerSAved;
    }

    @Override
    public Customer update(Long id, CustomerRequest customerRequest) {
        Customer  customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        customer.setName(customerRequest.name());
        customer.setEmail(customerRequest.email());
        return customer;

    }

    @Override
    public void delete(Long id) {
        Customer  customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        customerRepository.delete(customer);

    }

    @Override
    public Customer findByEmail(String email) {
        Customer  customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        return customer;
    }
}
